package com.ivs.tws.model.Maps;


import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.TimeUtils;


import java.util.Random;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

public class AbstractMap extends TiledMap {
    private final int LAYERS = 1;
    public int WIDTH;
    public int HEIGHT;
    public int TILES_PER_LAYER = WIDTH * HEIGHT;
    static final int TILE_WIDTH = 32;
    static final int TILE_HEIGHT = 32;
    static final int TILE_HEIGHT_DIAMOND = 32;
    public final int BOUND_X = HEIGHT * TILE_WIDTH / 2 + WIDTH * TILE_WIDTH / 2;
    public int BOUND_Y = HEIGHT * TILE_HEIGHT_DIAMOND / 2 + WIDTH * TILE_HEIGHT_DIAMOND / 2;


    int[] layers = new int[LAYERS];

    long startTime = TimeUtils.nanoTime();
    public Map Map;


    public Map create () {


        Map = new Map();


        Random rand = new Random();
        for (int i = 0; i < LAYERS; i++) {




            int colX = HEIGHT * TILE_WIDTH / 2 - TILE_WIDTH / 2;
            int colY = BOUND_Y - TILE_HEIGHT_DIAMOND;
            for (int x = 0; x < WIDTH; x++) {


                for (int y = 0; y < HEIGHT; y++) {
                    int tileX = colX - y * TILE_WIDTH / 2;
                    int tileY = colY - y * TILE_HEIGHT_DIAMOND / 2;
                }
                colX += TILE_WIDTH / 2;
                colY -= TILE_HEIGHT_DIAMOND / 2;
            }
        }
        return Map;
    }


    public void disposeMap () {
        Map.dispose();
    }



}