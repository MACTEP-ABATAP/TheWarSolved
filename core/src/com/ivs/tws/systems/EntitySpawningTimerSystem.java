package com.ivs.tws.systems;


import com.artemis.BaseEntitySystem;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.math.MathUtils;
import com.ivs.tws.components.Sprite;
import com.ivs.tws.core.Constants;
import com.ivs.tws.core.EntityFactory;

public class EntitySpawningTimerSystem extends BaseEntitySystem {

	private Timer timer1;
	private Timer timer2;
	private Timer timer3;

	public EntitySpawningTimerSystem() {
		timer1 = new Timer(2, true) {
			@Override
			public void execute() {
				EntityFactory.createEnemyShip(world, "enemy1", Sprite.Layer.ACTORS_3, 10, MathUtils.random(-Constants.FRAME_WIDTH / 2, Constants.FRAME_WIDTH / 2), Constants.FRAME_HEIGHT / 2 + 50, 0, -40, 20);
			}
		};

		timer2 = new Timer(6, true) {
			@Override
			public void execute() {
				EntityFactory.createEnemyShip(world, "enemy2", Sprite.Layer.ACTORS_2, 20, MathUtils.random(-Constants.FRAME_WIDTH / 2, Constants.FRAME_WIDTH / 2), Constants.FRAME_HEIGHT / 2 + 100, 0, -30, 40);
			}
		};

		timer3 = new Timer(12, true) {
			@Override
			public void execute() {
				EntityFactory.createEnemyShip(world, "enemy3", Sprite.Layer.ACTORS_1, 60, MathUtils.random(-Constants.FRAME_WIDTH / 2, Constants.FRAME_WIDTH / 2), Constants.FRAME_HEIGHT / 2 + 200, 0, -20, 70);
			}
		};
	}



	@Override
	protected void processSystem() {
		timer1.update((int) world.delta);
		timer2.update((int) world.delta);
		timer3.update((int) world.delta);
	}

}
