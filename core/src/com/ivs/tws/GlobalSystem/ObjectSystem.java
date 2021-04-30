package com.ivs.tws.GlobalSystem;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.ivs.tws.controller.Grid;
import com.ivs.tws.controller.Move;

public class ObjectSystem extends GestureSystem {
    private final static String TAG = "ObjectInputSystem";


    ComponentMapper<Grid> gpm;

    ComponentMapper<Move> mpm;

    IsoSystem camera;

    public int x;
    public int y;

    // Tap is on the Moon, NOT in space.
    private boolean validTap;

    @SuppressWarnings("unchecked")
    public ObjectSystem(IsoSystem camera) {
        super(Aspect.all(Grid.class, Move.class));

        this.camera = camera;
    }

    public ObjectSystem(Aspect.Builder aspect) {
        super(aspect);
    }

    @Override
    protected void processEntities(ImmutableBag<Entity> entities) {
        if (validTap) {
            validTap = false;
            Entity e = entities.get(0);
            Grid gp = gpm.get(e);
            Move mp = mpm.get(e);
            mp.currentTime = 0f;
            mp.startTime = 0f;
            mp.oldX = mp.x;
            mp.oldY = mp.y;
            mp.moving = true;
            gp.x = x;
            gp.y = y;
        }
    }

    @Override
    protected boolean checkProcessing() {
        return true;
    }

    Vector3 vec = new Vector3();

    @Override
    public boolean tap(float x, float y, int count, int button) {
        validTap = false;
        camera.unproject(vec.set(x, y, 0));
        IsoSystem.worldToGrid(vec);
        this.x = (int) vec.x;
        this.y = (int) vec.y;
        if (this.x >= 0 && this.x <= 48 && this.y >= 0 && this.y <= 48)
            validTap = true;
        return true;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        Gdx.app.log(TAG, "touchDown gesture");
        return false;
    }
}