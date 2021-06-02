package com.ivs.tws.core;



import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ivs.tws.systems.CollisionSystem;
import com.ivs.tws.systems.ColorAnimationSystem;
import com.ivs.tws.systems.EntitySpawningTimerSystem;
import com.ivs.tws.systems.ExpiringSystem;
import com.ivs.tws.systems.MovementSystem;
import com.ivs.tws.systems.ParallaxStarRepeatingSystem;
import com.ivs.tws.systems.PlayerInputSystem;
import com.ivs.tws.systems.RemoveOffscreenShipsSystem;
import com.ivs.tws.systems.ScaleAnimationSystem;
import com.ivs.tws.systems.SoundEffectSystem;
import com.ivs.tws.systems.SpriteRenderSystem;

public class GameScreen implements Screen {

	private World world;
	private OrthographicCamera camera;

	private SpriteRenderSystem spriteRenderSystem;

	private SpriteBatch batch;
	private Rectangle viewport;
	private PlayerInputSystem playerInputSystem;

	private static final float ASPECT_RATIO = (float) Constants.FRAME_WIDTH / (float) Constants.FRAME_HEIGHT;

	public GameScreen() {
		this.batch = new SpriteBatch();
		this.camera = new OrthographicCamera(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		;

		world = new World();
		WorldConfiguration config = new WorldConfigurationBuilder()
				.with(
						new GroupManager(),
						new MovementSystem(),
						this.playerInputSystem = new PlayerInputSystem(camera, viewport),
						new SoundEffectSystem(),
						new CollisionSystem(),
						new ExpiringSystem(),
						new EntitySpawningTimerSystem(),
						new ParallaxStarRepeatingSystem(),
						new ColorAnimationSystem(),
						new ScaleAnimationSystem(),
						new RemoveOffscreenShipsSystem(),
						this.spriteRenderSystem = (new SpriteRenderSystem(camera, batch))).build();
		world.getRegistered(GroupManager.class);
		World world = new World(config);
		EntityFactory.createPlayer(world, 0, 0).isActive();





		EntityFactory.createPlayer(world, 0, 0);

		for (int i = 0; 500 > i; i++) {
			EntityFactory.createStar(world);
		}

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		Gdx.gl.glViewport((int) viewport.x, (int) viewport.y,
                (int) viewport.width, (int) viewport.height);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		world.setDelta(delta);
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			for (int i = 0; 10 > i; i++) {
				world.process();
			}
		}
		world.process();

		spriteRenderSystem.process();

	}

	@Override
	public void resize(int width, int height) {
		// calculate new viewport
		float aspectRatio = (float) width / (float) height;
		float scale = 1f;
		Vector2 crop = new Vector2(0f, 0f);

		if (aspectRatio > ASPECT_RATIO) {
			scale = (float) height / (float)Constants.FRAME_HEIGHT;
			crop.x = (width - Constants.FRAME_WIDTH * scale) / 2f;
		} else if (aspectRatio < ASPECT_RATIO) {
			scale = (float) width / (float) Constants.FRAME_WIDTH;
			crop.y = (height - Constants.FRAME_HEIGHT * scale) / 2f;
		} else {
			scale = (float) width / (float) Constants.FRAME_WIDTH;
		}

		float w = (float) Constants.FRAME_WIDTH * scale;
		float h = (float) Constants.FRAME_HEIGHT * scale;
		viewport = new Rectangle(crop.x, crop.y, w, h);
		playerInputSystem.setViewport(viewport);
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
