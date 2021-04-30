package com.ivs.tws.GlobalSystem;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ivs.tws.controller.Grid;
import com.ivs.tws.controller.Move;

public class StaticRenderSystem extends EntityProcessingSystem {


    ComponentMapper<Grid> gpm;

    ComponentMapper<Move> mpm;

    IsoSystem camera;
    SpriteBatch batch;

    @SuppressWarnings("unchecked")
    public StaticRenderSystem(SpriteBatch batch, IsoSystem camera) {
        super(Aspect.all(Grid.class, Move.class));

        this.batch = batch;
        this.camera = camera;
    }

    @Override
    protected void begin() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
    }

    @Override
    protected void process(Entity e) {
        Move mp = mpm.get(e);
        Grid gp = gpm.get(e);
        batch.draw(gp.stSprite, mp.x , mp.y);
    }

    @Override
    protected void end() {
        batch.end();
    }


}
