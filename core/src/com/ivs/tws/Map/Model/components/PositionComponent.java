package com.ivs.tws.Map.Model.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class PositionComponent extends Component {
    public Vector2 position;

    public PositionComponent(float x, float y) {
        this.position = new Vector2(x,y);
    }

    public PositionComponent(Vector2 position) {
        this.position = new Vector2(position);
    }
}
