package com.ivs.tws.model.Objects;


import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;

import java.util.Objects;



public class Object extends AbstractObject {

    public enum State{
        NONE, NOT_DAMAGED, WEAK_DAMAGED, DAMAGED, BADLY_DAMAGED, SERIOUSLY_DAMAGED
    }








    //velocity of moving





    //current state
    Object.State state = State.NONE;





}
