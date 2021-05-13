package com.ivs.tws.Unit.component;

import com.artemis.Component;
import com.ivs.tws.Map.Model.Map.Terrain;

import java.util.EnumSet;
import java.util.Set;

public class UnitCommand extends Component {

    private static final int INITIAL_MILITARY_POWER = 10;

    public final Set<Terrain> forbiddenTiles = EnumSet.of(Terrain.SHALLOW_WATER, Terrain.DEEP_WATER, Terrain.ARCTIC);

    public int militaryPower = INITIAL_MILITARY_POWER;

    public int usedPower = 0;

    public int counter = 0;

}
