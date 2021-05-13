package com.ivs.tws.Unit;

import com.artemis.PooledComponent;

public class MutablePosition extends PooledComponent {


    public float x, y = 0.f;

    public MutablePosition() {
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    protected void reset() {
        x = y = 0f;
    }
}
