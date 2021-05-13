package com.ivs.tws.Map.Model.System;

import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.ivs.tws.Map.Model.Map.Iso.IsoCamera;

public class PrepareGraphicSystem extends EntityProcessingSystem {

    IsoCamera isoCamera;
    @Override
    protected void process(Entity e) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        isoCamera.update();

    }
}
