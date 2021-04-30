package com.ivs.tws.screens;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector3;
import com.ivs.tws.Assets;
import com.ivs.tws.GlobalSystem.*;


public class GameScreen implements Screen {

    private static final String TAG = "GameScreen";


    private MyGame iso;
    private IsoSystem camera;
    private SpriteBatch batch;

    private final World world = new World();

    private ObjectSystem ObjectSystem;
    private MapSystem mapSystem;

    private WorldConfiguration worldcfg;

    // The ordering matters for these when added to the InputMultiplexer and
    // when added to the World as Systems.


    // CONSTRUCTOR
    public GameScreen(MyGame iso) {
        this.iso = iso;

        this.camera = MyGame.camera;
        this.batch = MyGame.batch;



        ObjectSystem = new ObjectSystem(camera);

        mapSystem = new MapSystem(GlobalCfg.ORIG_CAM_X, GlobalCfg.ORIG_CAM_Y, GlobalCfg.ORIG_ZOOM_LEVEL, camera);

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(new GestureDetector(ObjectSystem));
        multiplexer.addProcessor(new GestureDetector(mapSystem));
        Gdx.input.setInputProcessor(multiplexer);


        worldcfg.setSystem(ObjectSystem);
        worldcfg.setSystem(mapSystem);
        worldcfg.setSystem(new AnimationSystem());
        worldcfg.setSystem(new StaticRenderSystem(batch, camera));
        worldcfg.setSystem(new BackgroundRenderSystem(batch, camera));
        world.create();

        createEntities();
    }

    // MAIN LOOP
    @Override
    public void render(float delta) {
        camera.clearScreen();
        world.setDelta(delta);
        world.process();
    }

    private void createEntities() {
    createBackgroundEntities();

    }

    private void createBackgroundEntities() {
        Entity backgroundTile;
        for (int i = 0; i < 4; ++i) {
            backgroundTile = world.createEntity();
            world.createEntity();
            worldcfg.register(backgroundTile);
            backgroundTile = world.createEntity();
            worldcfg.register(backgroundTile);
        }
    }

    private Vector3 vec = new Vector3();



    @Override
    public void resize(int width, int height) {
        Gdx.app.log(TAG, "resize");
    }

    @Override
    public void show() {
        Gdx.app.log(TAG, "show");
        // called when this screen is set as the screen with game.setScreen();
    }

    @Override
    public void hide() {
        Gdx.app.log(TAG, "hide");
        // called when current screen changes from this to a different screen
    }

    @Override
    public void pause() {
        Gdx.app.log(TAG, "pause");
    }

    @Override
    public void resume() {
        Gdx.app.log(TAG, "resume");
    }

    @Override
    public void dispose() {
        Gdx.app.log(TAG, "dispose");
        Assets.instance().loadLoaderAssets();
    }
}
