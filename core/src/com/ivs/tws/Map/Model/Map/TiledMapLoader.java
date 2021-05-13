package com.ivs.tws.Map.Model.Map;

import com.badlogic.gdx.utils.Array;
import com.ivs.tws.Map.Model.Map.Iso.IsoHelper;
import com.ivs.tws.Map.Model.Map.Iso.IsoTile;
import com.ivs.tws.Map.Model.Map.gataway.CellGateway;
import com.ivs.tws.Map.Model.Map.gataway.TiledMapGateway;
import com.ivs.tws.Map.Model.Map.gataway.TiledMapLayerGateway;
import com.ivs.tws.Map.Model.Map.tmx.ITmxMapLoader;
import com.ivs.tws.Map.Model.components.MapComponent;

public class TiledMapLoader {

    private ITmxMapLoader tmxMapLoader;

    public TiledMapLoader(ITmxMapLoader tmxMapLoader) {
        this.tmxMapLoader = tmxMapLoader;
    }

    public MapComponent loadMap(String path){
        TiledMapGateway tiledMapGateway = tmxMapLoader.load(path);
        int mapH = tiledMapGateway.mapH, mapW = tiledMapGateway.mapW;
        Array<Array<IsoTile>> tiles = IsoHelper.initializeTiles(mapW, mapH);

        for(TiledMapLayerGateway layerGateway : tiledMapGateway.layersGateway) {
            final int altitude = layerGateway.altitude;
            for (int row = mapH - 1; row >= 0; row--) {
                for (int col = 0; col < mapW; col++) {
                    final CellGateway cellGateway = layerGateway.getCellGateway(col, row);
                    if (!cellGateway.isEmpty()) {
                        tiles.get(col).set(row, new IsoTile(altitude, cellGateway.getTileTextureRegion()));
                    }
                }
            }
        }

        return new MapComponent(tiles,mapW,mapH);
    }
}
