package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.systems.IteratingSystem;
import com.ivs.tws.components.ColorAnimation;
import com.ivs.tws.components.Sprite;

public class ColorAnimationSystem extends IteratingSystem {
	ComponentMapper<ColorAnimation> cam;
	ComponentMapper<Sprite> sm;
	@SuppressWarnings("unchecked")
	public ColorAnimationSystem() {
		super(Aspect.all(ColorAnimation.class, Sprite.class));
	}

	@Override
	protected void process(int entityId) {
		ColorAnimation c = cam.get(entityId);
		Sprite sprite = sm.get(entityId);

		if(c.alphaAnimate) {
			sprite.a += c.alphaSpeed * world.delta;

			if(sprite.a > c.alphaMax || sprite.a < c.alphaMin) {
				if(c.repeat) {
					c.alphaSpeed = -c.alphaSpeed;
				} else {
					c.alphaAnimate = false;
				}
			}
		}
	}



}
