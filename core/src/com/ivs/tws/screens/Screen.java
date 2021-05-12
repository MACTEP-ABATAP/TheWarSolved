package com.ivs.tws.screens;

import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ivs.tws.Model.Map.Iso.IsoCamera;
import com.ivs.tws.Model.System.GridRenderer;

public class Screen extends ApplicationAdapter {
    private World world;
    IsoCamera isoCamera;

    @Override
    public void create () {

        WorldConfiguration setup = new WorldConfigurationBuilder()
                .with(new GridRenderer())
                .build();

        world = new World(setup);

        world.process();



    }

    @Override
    public void render () {
       isoCamera.update();
        world.setDelta(Gdx.graphics.getDeltaTime());
        world.process();

    }

    private void handleInput(IsoCamera cam) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            cam.zoom += 0.02;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            cam.zoom -= 0.02;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            cam.translate(-3, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            cam.translate(3, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            cam.translate(0, -3, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            cam.translate(0, 3, 0);
        }
    }
}

