package com.ivs.tws.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ivs.tws.Assets;
import com.ivs.tws.GlobalSystem.GlobalCfg;
import com.ivs.tws.GlobalSystem.IsoSystem;

public class LoaderScreen implements Screen {

    private static final String TAG = "LoaderScreen";

    private MyGame iso;
    private IsoSystem camera;
    private SpriteBatch batch;

    private Texture bgTexture;
    private Sprite bgSprite;

    private long startTime;
    private static final long TIME_TO_WAIT = 2000; // 2 second

    public LoaderScreen(MyGame iso) {
        this.iso = iso;
        this.camera = MyGame.camera;
        this.batch = MyGame.batch;

        Assets.instance().loadLoaderAssets();
        Assets.manager.finishLoading();

        Assets.instance().loadLoaderAssets();

        bgSprite = new Sprite(bgTexture);
        bgSprite.setBounds(0, 0, GlobalCfg.VIEWP_W, GlobalCfg.VIEWP_H);

        startTime = System.currentTimeMillis();
    }

    @Override
    public void render(float delta) {
        camera.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.disableBlending();
        bgSprite.draw(batch);
        batch.enableBlending();
        batch.end();

        Gdx.app.log(TAG, String.format("Current progress : %f", Assets.manager.getProgress()));

        if (Assets.manager.update() && (System.currentTimeMillis() - startTime > TIME_TO_WAIT)) {
            Gdx.app.log(TAG, "Done.");
            iso.setScreen(new GameScreen(iso));
            dispose();
        }
    }

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
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        Gdx.app.log(TAG, "resume");
        // TODO Auto-generated method stub
    }

    // This screen won't be disposed very often.
    @Override
    public void dispose() {
        Gdx.app.log(TAG, "dispose");
        Assets.instance().loadLoaderAssets();
    }
}
