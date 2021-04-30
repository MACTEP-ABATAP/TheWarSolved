package com.ivs.tws.GlobalSystem;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MapSystem extends GestureSystem {

    private final static String TAG = "MapInputSystem";

    private OrthographicCamera camera;

    private float velocityX = 0;
    private float velocityY = 0;

    private float scale;

    private boolean flinging = false;


    public MapSystem(float initX, float initY, float initScale, OrthographicCamera camera) {
        super(Aspect.one());

        this.scale = initScale;
        this.camera = camera;

        camera.zoom = initScale;
        camera.translate(initX, initY);
    }


    @Override
    protected void processEntities(ImmutableBag<Entity> entities) {

        if (flinging) {
            velocityX *= 0.95f;
            velocityY *= 0.95f;
            camera.translate(-velocityX * Gdx.graphics.getDeltaTime(), velocityY * Gdx.graphics.getDeltaTime());
            if (Math.abs(velocityX) < 0.01f) velocityX = 0;
            if (Math.abs(velocityY) < 0.01f) velocityY = 0;
        }



        if (camera.position.x < GlobalCfg.BORDER + GlobalCfg.VIEWP_W / 2)
            camera.position.x = GlobalCfg.BORDER + GlobalCfg.VIEWP_W / 2;
        if (camera.position.x > 4096 - GlobalCfg.BORDER - GlobalCfg.VIEWP_W / 2)
            camera.position.x = 4096 - GlobalCfg.BORDER - GlobalCfg.VIEWP_W / 2;
        if (camera.position.y < GlobalCfg.BORDER + GlobalCfg.VIEWP_H / 2)
            camera.position.y = GlobalCfg.BORDER + GlobalCfg.VIEWP_H / 2;
        if (camera.position.y > 2048 - GlobalCfg.BORDER - GlobalCfg.VIEWP_H / 2)
            camera.position.y = 2048 - GlobalCfg.BORDER - GlobalCfg.VIEWP_H / 2;

    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        Gdx.app.log(TAG, "pan gesture");
        camera.position.add(-deltaX * camera.zoom, deltaY * camera.zoom, 0);
        return true;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        Gdx.app.log(TAG, "fling gesture");
        flinging = true;
        this.velocityX = camera.zoom * velocityX * 0.5f;
        this.velocityY = camera.zoom * velocityY * 0.5f;
        return true;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        Gdx.app.log(TAG, "zoom gesture");
        float z = this.scale * (initialDistance / distance);
        if (z > GlobalCfg.MAX_ZOOM_LEVEL) z = GlobalCfg.MAX_ZOOM_LEVEL;
        if (z < GlobalCfg.MIN_ZOOM_LEVEL) z = GlobalCfg.MIN_ZOOM_LEVEL;
        camera.zoom = z;
        return true;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        Gdx.app.log(TAG, "touchDown gesture");
        flinging = false;
        scale = camera.zoom;
        return false;
    }
}
