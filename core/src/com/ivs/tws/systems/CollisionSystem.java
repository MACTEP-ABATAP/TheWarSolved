package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Wire;
import com.artemis.managers.GroupManager;
import com.artemis.utils.Bag;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.math.Vector2;
import com.ivs.tws.components.Bounds;
import com.ivs.tws.components.Health;
import com.ivs.tws.components.Position;
import com.ivs.tws.core.Constants;
import com.ivs.tws.core.EntityFactory;

@Wire
public class CollisionSystem extends EntitySystem {
	private ComponentMapper<Position> positionMapper;
	private ComponentMapper<Bounds> boundsMapper;
	private ComponentMapper<Health> healthMapper;
	
	private Bag<CollisionPair> collisionPairs;
	
	@SuppressWarnings("unchecked")
	public CollisionSystem() {
		super(Aspect.all(Position.class, Bounds.class));
	}

	@Override
	protected void processSystem() {

	}

	@Override
	public void initialize() {
		collisionPairs = new Bag<CollisionPair>();

		collisionPairs.add(new CollisionPair(Constants.Groups.PLAYER_BULLETS, Constants.Groups.ENEMY_SHIPS, new CollisionHandler() {
			@Override
			public void handleCollision(Entity bullet, Entity ship) {
				Position bp = positionMapper.get(bullet);
				EntityFactory.createSmallExplosion(world, bp.x, bp.y);
				for(int i = 0; 4 > i; i++) EntityFactory.createParticle(world, bp.x, bp.y);


				bullet.deleteFromWorld();
				//Expires bulletExpires = ex.get(bullet);
				//if(bulletExpires != null) {
				//	bulletExpires.delay = -1;
				//}

				Health health = healthMapper.get(ship);
				Position position = positionMapper.get(ship);
				health.health -= 1;
				if(health.health < 0) {
					health.health = 0;
					ship.deleteFromWorld();
					EntityFactory.createBigExplosion(world, position.x, position.y);
				}
			}
		}));
	}
	

	protected void processEntities(ImmutableBag<Entity> entities) {
		for(int i = 0; collisionPairs.size() > i; i++) {
			collisionPairs.get(i).checkForCollisions();
		}
	}


	@Override
	protected boolean checkProcessing() {
		return true;
	}
	
	
	private class CollisionPair {
		private ImmutableBag<Entity> groupEntitiesA;
		private ImmutableBag<Entity> groupEntitiesB;
		private CollisionHandler handler;

		public CollisionPair(String group1, String group2, CollisionHandler handler) {
			groupEntitiesA = world.getRegistered(GroupManager.class).getEntities(group1);
			groupEntitiesB = world.getRegistered(GroupManager.class).getEntities(group2);
			this.handler = handler;
		}

		public void checkForCollisions() {
			for(int a = 0; groupEntitiesA.size() > a; a++) {
				for(int b = 0; groupEntitiesB.size() > b; b++) {
					Entity entityA = groupEntitiesA.get(a);
					Entity entityB = groupEntitiesB.get(b);
					if(collisionExists(entityA, entityB)) {
						handler.handleCollision(entityA, entityB);
					}
				}
			}
		}
		
		private boolean collisionExists(Entity e1, Entity e2) {
			
			if(e1 == null || e2 == null) {
				return false;
			}
			
			//NPE!!!
			Position p1 = positionMapper.get(e1);
			Position p2 = positionMapper.get(e2);
			
			Bounds b1 = boundsMapper.get(e1);
			Bounds b2 = boundsMapper.get(e2);

			return (Vector2.len(p1.x - p2.x, p1.y - p2.y) - b1.radius) < b2.radius;
		}
	}
	
	private interface CollisionHandler {
		void handleCollision(Entity a, Entity b);
	}

}
