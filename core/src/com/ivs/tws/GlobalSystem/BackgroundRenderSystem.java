package com.ivs.tws.GlobalSystem;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.ivs.tws.Assets;

public class BackgroundRenderSystem extends EntityProcessingSystem {

    ComponentMapper<TileSystem> bpm;

    OrthographicCamera camera;
    SpriteBatch batch;

    Array<Texture> textures;


    public BackgroundRenderSystem(SpriteBatch batch, OrthographicCamera camera) {
        super(Aspect.all(TileSystem.class));

        this.batch = batch;
        this.camera = camera;

        textures = new Array<Texture>(8);
        textures.add(Assets.manager.get(Assets.BG0_0, Texture.class));
        textures.add(Assets.manager.get(Assets.BG0_0, Texture.class));
        textures.add(Assets.manager.get(Assets.BG0_0, Texture.class));
        textures.add(Assets.manager.get(Assets.BG0_0, Texture.class));
        textures.add(Assets.manager.get(Assets.BG0_0, Texture.class));
        textures.add(Assets.manager.get(Assets.BG0_0, Texture.class));
        textures.add(Assets.manager.get(Assets.BG0_0, Texture.class));
        textures.add(Assets.manager.get(Assets.BG0_0, Texture.class));
    }

    @Override
    protected void process(Entity e) {
        TileSystem bp = bpm.get(e);
        drawBackground(bp.x, bp.y);
    }

    @Override
    protected void begin() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.disableBlending();
    }

    private void drawBackground(int x, int y) {
        batch.draw(textures.get(x + 4 * y),
                x * GlobalCfg.BG_TILE_W,
                GlobalCfg.BG_TILE_H - (y * GlobalCfg.BG_TILE_H),
                GlobalCfg.BG_TILE_W,
                GlobalCfg.BG_TILE_H);
    }

    @Override
    protected void end() {
        batch.enableBlending();
        batch.end();
    }

}
