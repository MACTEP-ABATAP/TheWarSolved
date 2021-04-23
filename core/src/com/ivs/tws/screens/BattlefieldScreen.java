package com.ivs.tws.screens;


import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.ivs.tws.MyGame;
import com.ivs.tws.model.Maps.AbstractMap;
import com.ivs.tws.screens.ScreenUtil.AbstractScreen;

import java.util.Random;

public class BattlefieldScreen extends AbstractScreen {

    public short NumberOfTilesX;
    public short NumberOfTilesY;

    public int TileWidth = 64;
    public int TileHeight = 32;

    public int TileWidthHalf = TileWidth / 2;
    public int TileHeightHalf = TileHeight / 2;

    public int MapX = 0;
    public int MapY = 0;

    public static int ScreenY;
    public static int ScreenX;


    public InputMultiplexer inputHandler = new InputMultiplexer();

    public OrthographicCamera camera;
    public Stage stage;
    public SpriteBatch batch;

    private int defaultHeight;
    private boolean clippingEnabled = false;

//    private List<ArrayList<IsoTile>> worldTiles;
//    private Map<Integer, Texture> allTextures;
//    private Map<Integer, IsoTile> allTiles;


    private double currentTime = 0;
    private double timeSinceLastUpdate = 0;
    private double timeBetweenUpdates = 1000;


    private Map Map;
    private Touchpad touchpad;



    public void createUI (){

    }
    @Override
    public void create(){

    Map = new Map();
        MapProperties properties =

//        camera = new OrthographicCamera(STAGE_WIDTH, STAGE_HEIGHT);
//        camera.setToOrtho(false, STAGE_WIDTH, STAGE_HEIGHT);
//        batch = new SpriteBatch();
//        stage = new Stage(new StretchViewport(STAGE_WIDTH, STAGE_HEIGHT, camera), batch);
    }


    // Current level
    private int level;




    public BattlefieldScreen(Integer level) {
        super();
        this.level = level;

    }

    @Override
    public void buildStage() {
        // Adding actors






    }

    @Override
    public void dispose() {

    }



}
