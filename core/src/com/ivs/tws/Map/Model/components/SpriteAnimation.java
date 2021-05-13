package com.ivs.tws.Map.Model.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteAnimation extends Component {

    public Animation<TextureRegion> animation;

    public float stateTime = 0f;

    public float frameDuration = 0.1f;

    public Animation.PlayMode playMode = Animation.PlayMode.NORMAL;

    public SpriteAnimation() {
    }

    public TextureRegion getFrame() {
        return animation.getKeyFrame(stateTime);
    }
}
