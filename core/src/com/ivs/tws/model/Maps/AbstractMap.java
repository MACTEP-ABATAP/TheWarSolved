package com.ivs.tws.model.Maps;


import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapProperties;


import java.util.Random;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

public class AbstractMap extends Map {
    public static int WIDTH ;
    public static int HEIGHT;
    public static int LAYERS;
    public static final int TILES_PER_LAYER = WIDTH * HEIGHT;
    public static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;

    public static final int TILE_HEIGHT_DIAMOND = 32;
    private int BOUND_X = HEIGHT * TILE_WIDTH / 2 + WIDTH * TILE_WIDTH / 2;
    private int BOUND_Y = HEIGHT * TILE_HEIGHT_DIAMOND / 2 + WIDTH * TILE_HEIGHT_DIAMOND / 2;

    SpriteCache[] caches = new SpriteCache[LAYERS];

    int[] layers = new int[LAYERS];



    public void generateMap(){
        Random rand = new Random();
        for (int i = 0; i < LAYERS; i++) {
            caches[i] = new SpriteCache();
            SpriteCache cache = caches[i];
            cache.beginCache();


            int colX = HEIGHT * TILE_WIDTH / 2 - TILE_WIDTH / 2;
            int colY = BOUND_Y - TILE_HEIGHT_DIAMOND;
            for (int y = 0; x < WIDTH; x++) {


                for (int y = 0; y < HEIGHT; y++) {
                    int tileX = colX - y * TILE_WIDTH / 2;
                    int tileY = colY - y * TILE_HEIGHT_DIAMOND / 2;
                    cache.add(texture, tileX, tileY, rand.nextInt(2) * 64, TILE_WIDTH, TILE_HEIGHT);
                }
                colX += TILE_WIDTH / 2;
                colY -= TILE_HEIGHT_DIAMOND / 2;
            }
            layers[i] = cache.endCache();
        }
    }





    private MapProperties properties = new MapProperties();

    @Override
    public MapProperties getProperties() {
        return properties;
    }




    @Override
    public void dispose() {
        super.dispose();
    }
}
