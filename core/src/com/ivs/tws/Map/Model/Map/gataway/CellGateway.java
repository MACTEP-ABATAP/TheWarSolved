package com.ivs.tws.Map.Model.Map.gataway;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class CellGateway {
    private TextureRegion tileTextureRegion;

    public CellGateway() {

    }

    public CellGateway(TiledMapTileLayer.Cell cell) {
        if (cell != null) {
            tileTextureRegion = cell.getTile().getTextureRegion();
        }
    }

    public TextureRegion getTileTextureRegion() {
        return tileTextureRegion;
    }

    public boolean isEmpty() {
        return tileTextureRegion == null;
    }
}
