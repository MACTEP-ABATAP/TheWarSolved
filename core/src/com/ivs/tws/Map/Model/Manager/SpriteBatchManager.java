package com.ivs.tws.Map.Model.Manager;

import com.artemis.Manager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteBatchManager extends Manager {
    public SpriteBatch spriteBatch;

    public SpriteBatchManager() {
        spriteBatch = new SpriteBatch();
    }
}
