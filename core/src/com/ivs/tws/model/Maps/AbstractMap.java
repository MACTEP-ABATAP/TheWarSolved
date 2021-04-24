package com.ivs.tws.model.Maps;


import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.TimeUtils;


import java.util.Random;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

public class AbstractMap extends Map {

    public short NumberOfTilesX;
    public short NumberOfTilesY;

    public int TileWidth = 64;
    public int TileHeight = 32;

    public int MapX = 0;
    public int MapY = 0;

    public int TileWidthHalf = TileWidth / 2;
    public int TileHeightHalf = TileHeight / 2;

    public MapLayers layers = new MapLayers();
    public MapProperties properties = new MapProperties();







    @Override
    public MapLayers getLayers() {
        return super.getLayers();
    }

    @Override
    public MapProperties getProperties() {
        return super.getProperties();
    }
}