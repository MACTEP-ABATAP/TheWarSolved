package com.ivs.tws.Unit.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import java.util.function.Supplier;

public class TextBox  extends Component {

    public final Supplier<String> generator;

    public String text;

    public Texture texture;

    public Color color;

    public TextBox(Supplier<String> generator) {
        this.generator = generator;
    }

    @Override
    public String toString() {
        return text != null ? text : "<null>";
    }

}

