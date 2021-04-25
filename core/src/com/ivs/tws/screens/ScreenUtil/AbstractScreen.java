package com.ivs.tws.screens.ScreenUtil;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.ivs.tws.Maps.MapTile;

import java.util.Map;

public abstract class AbstractScreen extends Stage implements Screen {

    protected AbstractScreen() {
        super( new StretchViewport(320.0f, 240.0f, new OrthographicCamera()) );
    }

    public abstract void create();

    public abstract void render();


    public abstract void buildStage();



    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height, true);
    }

    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}

    protected abstract Texture mapTextures();

    protected abstract Map<Integer, MapTile> createTiles();
}

