package com.ivs.tws.Model.components;

import com.artemis.Component;
import com.badlogic.gdx.utils.Array;
import com.ivs.tws.Model.Map.GridPosition;
import com.ivs.tws.Model.Map.Iso.IsoTile;

public class MapComponent extends Component {

    private Array<Array<IsoTile>> tiles;
    public int mapWidth;
    public int mapHeight;


    public MapComponent(Array<Array<IsoTile>> tiles,int mapW,int mapH){
        this.tiles = tiles;
        this.mapWidth = mapW;
        this.mapHeight = mapH;
    }

    public Array<Array<IsoTile>> getTiles() {
        return tiles;
    }

    public IsoTile getTile(int x, int y) {
        if(tiles.size > x){
            Array<IsoTile> col = tiles.get(x);
            if(col != null && col.size > y){
                return col.get(y);
            }
        }
        return null;

    }

    public Integer getCost(GridPosition current, GridPosition neighbor) {
        return 0;
    }
}

