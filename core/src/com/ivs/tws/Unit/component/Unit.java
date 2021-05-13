package com.ivs.tws.Unit.component;

import com.artemis.Component;
import com.artemis.Entity;

public class Unit extends Component {

    public final int maxHealtPoint;

    public int currentHealthPoint;

    public final Entity source;

    public Unit(Entity source, int currentHealthPoint){
        this.source  = source;
        this.maxHealtPoint = currentHealthPoint;
        this.currentHealthPoint = currentHealthPoint;
    }

}
