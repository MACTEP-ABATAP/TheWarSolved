package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.DelayedEntityProcessingSystem;
import com.ivs.tws.components.Expires;

@Wire
public class ExpiringSystem extends DelayedEntityProcessingSystem {
	private ComponentMapper<Expires> expirationMapper;

	@SuppressWarnings("unchecked")
    public ExpiringSystem() {
		super(Aspect.all(Expires.class));
	}
	
	@Override
	protected void processDelta(Entity e, float accumulatedDelta) {
		Expires expires = expirationMapper.get(e);
		expires.delay -= accumulatedDelta;
	}

	@Override
	protected void processExpired(Entity e) {
		e.deleteFromWorld();
	}
	
	@Override
	protected float getRemainingDelay(Entity e) {
		Expires expires = expirationMapper.get(e);
		return expires.delay;
	}
}
