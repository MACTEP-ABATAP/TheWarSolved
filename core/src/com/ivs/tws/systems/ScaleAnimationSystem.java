package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;

import com.artemis.systems.EntityProcessingSystem;
import com.artemis.systems.IteratingSystem;
import com.ivs.tws.components.ScaleAnimation;
import com.ivs.tws.components.Sprite;

public class ScaleAnimationSystem extends IteratingSystem {

	ComponentMapper<ScaleAnimation> sa;
	ComponentMapper<Sprite> sm;

	@SuppressWarnings("unchecked")
    public ScaleAnimationSystem() {
		super(Aspect.all(ScaleAnimation.class));
	}

	@Override
	protected void process(int e) {
		ScaleAnimation scaleAnimation = sa.get(e);
		if (scaleAnimation.active) {
			Sprite sprite = sm.get(e);

			sprite.scaleX += scaleAnimation.speed * world.delta;
			sprite.scaleY = sprite.scaleX;

			if (sprite.scaleX > scaleAnimation.max) {
				sprite.scaleX = scaleAnimation.max;
				scaleAnimation.active = false;
			} else if (sprite.scaleX < scaleAnimation.min) {
				sprite.scaleX = scaleAnimation.min;
				scaleAnimation.active = false;
			}
		}
	}

}
