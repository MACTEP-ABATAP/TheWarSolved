package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.ivs.tws.components.Position;
import com.ivs.tws.components.Velocity;

public class MovementSystem extends EntityProcessingSystem {
	ComponentMapper<Position> pm;
	ComponentMapper<Velocity> vm;

	@SuppressWarnings("unchecked")
    public MovementSystem() {
		super(Aspect.all(Position.class, Velocity.class));
	}

	@Override
	protected void process(Entity e) {
		Position position = pm.get(e);
		Velocity velocity = vm.get(e);
		
		if(velocity == null) {
		    return;
		}
		position.x += velocity.vectorX*world.delta;
		position.y += velocity.vectorY*world.delta;
	}

}
