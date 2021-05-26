package com.ivs.tws.systems;



import com.artemis.Aspect;

import com.artemis.ComponentMapper;
import com.artemis.Entity;

import com.artemis.systems.DelayedEntityProcessingSystem;
import com.ivs.tws.components.Expires;

public class ExpiringSystem extends DelayedEntityProcessingSystem {

	ComponentMapper<Expires> em;


    public ExpiringSystem() {
		super(Aspect.all(Expires.class));
	}
	
	@Override
	protected void processDelta(Entity e, float accumulatedDelta) {
		Expires expires = em.get(e);
		expires.delay -= accumulatedDelta;
	}

	@Override
	protected void processExpired(Entity e) {
		e.deleteFromWorld();
	}
	
	@Override
	protected float getRemainingDelay(Entity e) {
		Expires expires = em.get(e);
		return expires.delay;
	}
}
