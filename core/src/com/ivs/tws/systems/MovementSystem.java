package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import com.ivs.tws.components.Position;
import com.ivs.tws.components.Velocity;

@Wire
public class MovementSystem extends EntityProcessingSystem {
	private ComponentMapper<Position> positionMapper;
	private ComponentMapper<Velocity> velocityMapper;

	@SuppressWarnings("unchecked")
    public MovementSystem() {
		super(Aspect.all(Position.class, Velocity.class));
	}

	@Override
	protected void process(Entity e) {
		Position position = positionMapper.get(e);
		Velocity velocity = velocityMapper.get(e);
		
		if(velocity == null) {
		    return;
		}
		position.x += velocity.vectorX * world.delta;
		position.y += velocity.vectorY * world.delta;
	}

}
