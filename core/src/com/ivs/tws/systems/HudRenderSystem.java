package com.ivs.tws.systems;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ivs.tws.core.Constants;

import java.util.HashMap;

public class HudRenderSystem extends BaseSystem {

    private HashMap<String, TextureAtlas.AtlasRegion> regions;
    private TextureAtlas textureAtlas;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private BitmapFont font;

    public HudRenderSystem(OrthographicCamera camera) {
        this.camera = camera;
    }

    @Override
    protected void initialize() {
        regions = new HashMap<String, TextureAtlas.AtlasRegion>();
        textureAtlas = new TextureAtlas("images-packed/pack.atlas");
        for (TextureAtlas.AtlasRegion r : textureAtlas.getRegions()) {
            regions.put(r.name, r);
        }

        batch = new SpriteBatch();

        Texture fontTexture = new Texture(Gdx.files.internal("fonts/normal_0.png"));
        fontTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.MipMapLinearLinear);

        TextureRegion fontRegion = new TextureRegion(fontTexture);
        font = new BitmapFont(Gdx.files.internal("fonts/normal.fnt"), fontRegion, false);
        font.setUseIntegerPositions(false);
    }

    @Override
    protected void begin() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
    }


    @Override
    protected void processSystem() {
        batch.setColor(1, 1, 1, 1);
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), -(Constants.FRAME_WIDTH / 2) + 20, Constants.FRAME_HEIGHT / 2 - 20);
        //font.draw(batch, "Score " + , -(Constants.FRAME_WIDTH / 2) + 20, Constants.FRAME_HEIGHT / 2 - 40);

    }
}
