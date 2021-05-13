package com.ivs.tws.Unit.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Description extends Component {

    public String desc;

    public final TextureAtlas.AtlasRegion texture;

    public Description(String desc) {
        this(desc, null);
    }

    public Description(String desc, TextureAtlas.AtlasRegion texture) {
        this.desc = desc;
        this.texture = texture;
    }

    @Override
    public String toString() {
        return desc;
    }
}
