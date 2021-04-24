package com.ivs.tws.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.ivs.tws.Maps.MapTile;
import com.ivs.tws.Maps.TileType;
import com.ivs.tws.screens.ScreenUtil.AbstractScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BattlefieldScreen extends AbstractScreen {



    public static float StageWidth;
    public static float StageHeight;
    private int defaultHeight;

    private List<ArrayList<MapTile>> mapTiles;
    private Map<Integer, Texture> mapTextures;
    private Map<Integer, MapTile> tiles;
    private MapPoint = new MapPoint();
    public SpriteBatch batch;

    public Stage battlefield;

    public OrthographicCamera camera;
    public InputMultiplexer input = new InputMultiplexer();
    private double currentTime = 0;
    private double timeFromLastUpdate = 0;
    private double timeBetweenUpdates = 1000;


    @Override
    public void create() {
        BattlefieldScreen.StageWidth = 1400;
        BattlefieldScreen.StageHeight = 800;

        camera = new OrthographicCamera(StageWidth, StageHeight);
        camera.setToOrtho(false, StageWidth, StageHeight);
        batch = new SpriteBatch();
        battlefield = new Stage(new StretchViewport(StageWidth, StageHeight, camera), batch);
        input.addProcessor(battlefield);

        Gdx.input.setInputProcessor(input);

        //this.mapTextures = this.loadTextures();

        //Texture defaultTile = this.mapTextures();
        //this.defaultHeight = defaultTile.getHeight();
        //this.mapTiles = this.createTileSet();

        //this.tiles = this.createTiles()
    }

    private Map<Integer, Texture> loadTexture() {
        Map<Integer, Texture> texture = new HashMap<Integer, Texture>();
        for (TileType type : TileType.values()) {
            Texture texture1 = new Texture(type.fileName());
            texture.put(type.id(), texture1);
        }
        return texture;
    }

    private Map<Integer, MapTile> createTileSet() {
        Map<Integer, MapTile> tileSet = new HashMap<Integer, MapTile>();
        for (TileType type : TileType.values()) {
            tileSet.put(type.id(), new MapTile(this.mapTextures.get(type.id()), type.id(), this.defaultHeight));
        }
        return tileSet;
    }

    private List<ArrayList<MapTile>> createWorldTiles(int[][] mapTileData){
        List<ArrayList<MapTile>> isoTiles = new ArrayList<ArrayList<MapTile>>();
        for (int x = this.Maps.Map.levelData.length - 1; x >= 0 ; x--) {
            ArrayList<MapTile> row = new ArrayList<MapTile>();
            for (int y = this.Maps.Map.levelData[x].length - 1; y >= 0; y--) {
                int tileType = this.Maps.Map.levelData[x][y];
                row.add(this.tiles.get(tileType));
            }
            isoTiles.add(row);
        }
        return isoTiles;
    }
    @Override
    public void render(){
        Gdx.gl.glClearColor(0.2f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        battlefield.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        battlefield.draw();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        super.render();

        this.updateWorld(this.mapTiles);

        int scaleReducer = 12;
        float gapReducer = 0.78f; //smaller is a smaller gap
        for (int x = this.mapTiles.size() - 1; x >= 0; x--) {
            List<MapTile> row = this.mapTiles.get(x);
            for (int y = row.size() - 1; y >= 0; y--) {
                MapTile tile = row.get(y);
                point.set((int)(x * this.defaultHeight * gapReducer / scaleReducer),
                        (int)(y * this.defaultHeight * gapReducer / scaleReducer));
                point.convertTwoDToIso();


                int count = 0;
                for (int h = 0; h < tile.textures.size(); h++) {


                    if (count > 0) {
                        break;
                    } else {
                        count++;
                    }


                    TextureRegion textureRegion = tile.textures.get(h);
                    batch.draw(textureRegion,
                            point.x,
                            point.y + h * this.defaultHeight / scaleReducer,
                            textureRegion.getRegionWidth() / scaleReducer,
                            textureRegion.getRegionHeight() / scaleReducer);;
                }
            }
        }

        this.batch.end();

        double newTime = TimeUtils.millis();
        double timeElapsed = newTime - this.currentTime;
        this.currentTime = newTime;
        this.timeFromLastUpdate += timeElapsed;

        if (this.timeFromLastUpdate > this.timeBetweenUpdates) {
            this.timeFromLastUpdate = 0;
            this.Maps.Map.updateWorld();
        }
    }

    private void updateWorld(List<ArrayList<MapTile>> world) {
        for (int x = this.Maps.Map.levelData.length - 1; x >= 0 ; x--) {
            ArrayList<MapTile> row = world.get(x);
            for (int y = this.Maps.Map.levelData[x].length - 1; y >= 0; y--) {
                int tileType = this.Maps.Map.levelData[x][y];
                MapTile currentTile = row.get(y);
                if (currentTile.getTileType() != tileType) {
                    row.set(y, this.tiles.get(tileType));
                }
            }
        }
    }

    @Override
    public void buildStage() {

    }

    @Override
    public void dispose(){

    }
}
