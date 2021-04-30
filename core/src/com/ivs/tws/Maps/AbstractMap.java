package com.ivs.tws.Maps;


import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapProperties;

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