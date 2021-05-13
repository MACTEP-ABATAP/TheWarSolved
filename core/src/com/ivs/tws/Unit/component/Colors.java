package com.ivs.tws.Unit.component;

import com.artemis.Entity;
import com.badlogic.gdx.graphics.Color;

public class Colors {

    private Colors() {
    }


    @SuppressWarnings("javadoc")
    public static Color contrast(Color c) {
        float yiq = ((c.r * 256 * 299f) + (c.g * 256 * 587f) + (c.b * 256 * 114f)) / 1000f;
        return (yiq >= 128f) ? Color.BLACK : Color.WHITE;

    }

    public static String markup(Entity empire) {
        return markup(empire.getComponent(Empire.class).color);
    }

    public static String markup(Color c) {
        return "[#" + c.toString().toUpperCase() + "]";
    }
}
