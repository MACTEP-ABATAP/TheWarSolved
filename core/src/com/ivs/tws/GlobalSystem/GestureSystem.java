package com.ivs.tws.GlobalSystem;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public abstract class GestureSystem extends EntitySystem implements GestureDetector.GestureListener {

    public GestureSystem(Aspect.Builder aspect) {
        super(aspect);
    }



    @Override
    protected void processSystem() {

    }

    @Override
    protected boolean checkProcessing() {
        return true;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    protected abstract void processEntities(ImmutableBag<Entity> entities);

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1,
                         Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }




}
