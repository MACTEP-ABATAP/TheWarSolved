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

    public int getTileWidth() {
        return TileWidth;
    }

    public void setTileWidth(int tileWidth) {
        TileWidth = tileWidth;
    }


    public int getTileHeight() {
        return TileHeight;
    }

    public void setTileHeight(int tileHeight) {
        TileHeight = tileHeight;
    }



    public short getNumberOfTilesY() {
        return NumberOfTilesY;
    }

    public void setNumberOfTilesY(short numberOfTilesY) {
        NumberOfTilesY = numberOfTilesY;
    }



    public int getMapX() {
        return MapX;
    }

    public void setMapX(int mapX) {
        MapX = mapX;
    }

    public int getMapY() {
        return MapY;
    }

    public void setMapY(int mapY) {
        MapY = mapY;
    }



    public short getNumberOfTilesX() {
        return NumberOfTilesX;
    }

    public void setNumberOfTilesX(short numberOfTilesX) {
        NumberOfTilesX = numberOfTilesX;
    }

    @Override
    public MapLayers getLayers() {
        return super.getLayers();
    }

    @Override
    public MapProperties getProperties() {
        return super.getProperties();
    }
}