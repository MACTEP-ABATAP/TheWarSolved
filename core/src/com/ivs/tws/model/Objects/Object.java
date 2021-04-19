package com.ivs.tws.model.Objects;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Objects;



public class Object extends AbstractObject {

    public enum State{
        NONE, NOT_DAMAGED, WEAK_DAMAGED, DAMAGED, BADLY_DAMAGED, SERIOUSLY_DAMAGED
    }




    //size




    //velocity of moving
    public static float SPEED = 2f;


    //Position on world
    Vector2 position = new Vector2();
    //Calculating velocity
    Vector2 velocity = new Vector2();
    //Object rectangle for collision

    //current state
    Object.State state = State.NONE;

    public Object(Vector2 pos){
        this.position = pos;

    }





    public Vector2 getPosition() {
        return position;
    }



}
