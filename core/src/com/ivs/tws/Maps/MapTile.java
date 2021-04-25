package com.ivs.tws.Maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapTile {
    private int unitHeight;
    private int tileType;
    public List<TextureRegion> textures;

    public MapTile(Texture texture, int tileType, int unitHeight) {
        this.tileType = tileType;
        this.unitHeight = unitHeight;
        this.textures = this.splitTextureIntoRegions(texture);
    }


    public int getTileType() {
        return this.tileType;
    }

    private List<TextureRegion> splitTextureIntoRegions(Texture texture) {
        TextureRegion textureRegion = new TextureRegion(texture);
        List<TextureRegion> textures = new ArrayList<TextureRegion>();
        if (texture.getHeight() > this.unitHeight) {
            TextureRegion[][] textureMatrix = textureRegion.split(texture.getWidth(), this.unitHeight);
            for (int i = textureMatrix.length - 1; i >= 0; i--) {
                TextureRegion[] textureArray = textureMatrix[i];
                Collections.addAll(textures, textureArray);
            }
        } else {
            textures.add(textureRegion);
        }
        return textures;
    }
}
