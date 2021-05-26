package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.ivs.tws.components.ColorAnimation;
import com.ivs.tws.components.Sprite;

public class ColorAnimationSystem extends EntityProcessingSystem {
	ComponentMapper<ColorAnimation> cam;
	ComponentMapper<Sprite> sm;

	public ColorAnimationSystem() {
		super(Aspect.all(ColorAnimation.class, Sprite.class));
	}

	@Override
	protected void process(Entity e) {
		ColorAnimation c = cam.get(e);
		Sprite sprite = sm.get(e);
		
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
