package com.ivs.tws.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ivs.tws.Assets;
import com.ivs.tws.GlobalSystem.GlobalCfg;
import com.ivs.tws.GlobalSystem.IsoSystem;


public class MyGame extends Game {

    static IsoSystem camera;
    static SpriteBatch batch;

    private static final String TAG = "Isometric";

    @Override
    public void create() {
        camera = new IsoSystem();
        camera.setToOrtho(false, GlobalCfg.VIEWP_W, GlobalCfg.VIEWP_H);
        
        Assets.instance();

        batch = new SpriteBatch();

        setScreen(new LoaderScreen(this));
    }

    @Override
    public void dispose() {
        Gdx.app.log(TAG, "dispose");
        getScreen().dispose();
        batch.dispose();
        Assets.clear();
    }

    @Override
    public void render() {
        super.render();
        getScreen().render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(TAG, "resize");
        getScreen().resize(width, height);
    }

    @Override
    public void pause() {
        Gdx.app.log(TAG, "pause");
        getScreen().pause();
    }

    @Override
    public void resume() {
        Gdx.app.log(TAG, "resume");
        getScreen().resume();
    }
}
