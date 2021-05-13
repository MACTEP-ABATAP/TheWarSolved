package com.ivs.tws.screens;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;
import com.artemis.utils.EntityBuilder;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.ivs.tws.Map.Model.GlobalCfg;
import com.ivs.tws.Map.Model.Manager.CameraManager;
import com.ivs.tws.Map.Model.Manager.SpriteBatchManager;
import com.ivs.tws.Map.Model.Map.Iso.IsoCamera;
import com.ivs.tws.Map.Model.Map.Iso.IsoHelper;
import com.ivs.tws.Map.Model.Map.Map;
import com.ivs.tws.Map.Model.Map.TiledMapLoader;
import com.ivs.tws.Map.Model.Map.gataway.CellGateway;
import com.ivs.tws.Map.Model.Map.tmx.LibgdxTmxMapLoader;
import com.ivs.tws.Map.Model.System.GridRenderer;
import com.ivs.tws.Map.Model.System.PrepareGraphicSystem;
import com.ivs.tws.Map.Model.components.PositionComponent;
import com.ivs.tws.Map.Model.components.TextureComponent;

import java.util.ArrayList;

public class Screen extends ApplicationAdapter {
    private World world;
    IsoCamera isoCamera;

    @Override
    public void create () {

        WorldConfiguration setup = new WorldConfigurationBuilder()
                .with(new CameraManager(), new SpriteBatchManager()  )
                .with(new PrepareGraphicSystem(), new GridRenderer() )
                //.with()
                .build();


        world = new World(setup);

        world.process();



    }

    Entity perso = new EntityBuilder(world).with(new PositionComponent(IsoHelper.toIsoCenterWorldCoord(1,1, GlobalCfg.TILE_W, GlobalCfg.TILE_H, GlobalCfg.TILE_DEPTH)))
            .with(new TextureComponent(new Texture("Tiles/alienBlue.png")))
            .build();

    LibgdxTmxMapLoader libgdxTmxMapLoader = new LibgdxTmxMapLoader();
    TiledMapLoader tiledMapLoader = new TiledMapLoader(libgdxTmxMapLoader);


    @Override
    public void render () {
        CameraManager cameraManager = world.getRegistered(CameraManager.class);
        handleInput(cameraManager.camera);
        cameraManager.camera.update();
        world.setDelta(Gdx.graphics.getDeltaTime());
        world.process();

    }

    public void handleInput(OrthographicCamera cam) {

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

