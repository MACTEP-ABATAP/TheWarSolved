package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;

import com.artemis.systems.IntervalEntityProcessingSystem;
import com.ivs.tws.components.ParallaxStar;
import com.ivs.tws.components.Position;
import com.ivs.tws.core.Constants;

public class ParallaxStarRepeatingSystem extends IntervalEntityProcessingSystem {

	ComponentMapper<Position> pm;


    public ParallaxStarRepeatingSystem() {
		super(Aspect.all(ParallaxStar.class, Position.class), 1);
	}

	@Override
	protected void process(Entity e) {
		Position position = pm.get(e);

		if (position.y < -Constants.FRAME_HEIGHT / 2) {
			position.y = Constants.FRAME_HEIGHT / 2;
		}
	}

}
