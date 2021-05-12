package com.ivs.tws.Model.Map.Iso;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class IsoTile {
    public int height;
    public TextureRegion texture;

    public IsoTile(int height,TextureRegion texture){
        this.height = height;
        this.texture = texture;
    }
}
