package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;

import com.artemis.systems.IntervalEntityProcessingSystem;
import com.ivs.tws.components.Bounds;
import com.ivs.tws.components.Health;
import com.ivs.tws.components.Position;
import com.ivs.tws.components.Velocity;
import com.ivs.tws.core.Constants;

public class RemoveOffscreenShipsSystem extends IntervalEntityProcessingSystem {
	ComponentMapper<Position> pm;
	ComponentMapper<Bounds> bm;

	@SuppressWarnings("unchecked")
    public RemoveOffscreenShipsSystem() {
		super(Aspect.all(Velocity.class, Position.class, Health.class, Bounds.class), 5);
	}

	@Override
	protected void process(Entity e) {
		Position position = pm.get(e);
		Bounds bounds = bm.get(e);
		
		if(position.y < -Constants.FRAME_HEIGHT/2-bounds.radius) {
			e.deleteFromWorld();
		}
	}

}
