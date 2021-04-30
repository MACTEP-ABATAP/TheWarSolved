package com.ivs.tws.controller;

import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Grid extends Component {

    public int x;
    public int y;

    public int w;
    public int h;

    public Sprite stSprite = null;

    public Grid (int x, int y) {
        this(x, y, 1, 1, null);
    }

    public Grid(int x, int y, int w, int h) {
        this(x, y, w, h, null);
    }

    public Grid(int x, int y, int w, int h, Sprite textureRegion) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.stSprite = textureRegion;
    }
}
