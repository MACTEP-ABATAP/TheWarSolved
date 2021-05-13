package com.ivs.tws.Unit.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;

import java.util.concurrent.atomic.AtomicInteger;

public class Empire extends Component {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public final int id;

    public final Color color;

    public final Color backColor;



    private final boolean computer;

    public Empire(Color color, boolean computer) {
        this.id = COUNTER.getAndIncrement();
        this.color = color;
        this.backColor = Colors.contrast(color);
        this.computer = computer;
    }

    public boolean isComputerControlled() {
        return computer;
    }

    public Color getColor() {
        return color;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        else if (obj instanceof Empire)
            return id == ((Empire) obj).id;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "(ia=" + computer + ")";
    }
}
