package com.ivs.tws.Unit.component;

import com.artemis.Component;
import com.ivs.tws.Map.Model.Map.MapPosition;
import com.ivs.tws.Map.Model.Map.Terrain;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Destination extends Component {

    public final Set<Terrain> forbiddenTiles;

    public MapPosition target;

    public List<MapPosition> path;

    public final int turnsToMove;


    public int progress;

    public Destination(Set<Terrain> forbiddenTiles,int turnsToMove) {
        this.turnsToMove = turnsToMove;
        this.forbiddenTiles = EnumSet.copyOf(forbiddenTiles);
    }
}
