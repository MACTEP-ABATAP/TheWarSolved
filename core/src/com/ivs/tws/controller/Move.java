package com.ivs.tws.controller;

import com.artemis.Component;

public class Move extends Component {

    public float x;
    public float y;

    public float oldX;
    public float oldY;

    public float startTime = 0;
    public float currentTime = 0;

    public boolean moving = false;

    public Move(float x, float y) {
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;
    }
}
