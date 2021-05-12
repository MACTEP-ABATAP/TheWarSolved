package com.ivs.tws.Model.Map;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapProperties;

public class Map extends com.badlogic.gdx.maps.Map {

    MapProperties mapProperties;
    MapLayer layer;


    public void setLayer(MapLayer layer) {
        this.layer = layer;
    }

    public void setMapProperties(MapProperties mapProperties) {
        this.mapProperties = mapProperties;
    }

    public MapLayer getLayer() {
        return layer;
    }

    public MapProperties getMapProperties() {
        return mapProperties;
    }

    @Override
    public MapProperties getProperties() {
        return super.getProperties();
    }

    @Override
    public MapLayers getLayers() {
        return super.getLayers();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
