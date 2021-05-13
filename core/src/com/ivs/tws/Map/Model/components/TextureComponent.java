package com.ivs.tws.Map.Model.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Texture;

 public class TextureComponent extends Component {
    public Texture texture;

    public TextureComponent(Texture texture) {
        this.texture = texture;
    }
}
