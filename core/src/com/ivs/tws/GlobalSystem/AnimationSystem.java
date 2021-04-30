package com.ivs.tws.GlobalSystem;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.math.Vector3;
import com.ivs.tws.controller.Grid;
import com.ivs.tws.controller.Move;

public class AnimationSystem extends EntityProcessingSystem {

    private final static String TAG = "SimpleAnimationSystem";


    ComponentMapper<Grid> gpm;

    ComponentMapper<Move> mpm;

    @SuppressWarnings("unchecked")
    public AnimationSystem() {
        super(Aspect.all(Grid.class, Move.class));
    }

    private Vector3 vec = new Vector3();

    @Override
    protected void process(Entity e) {
        Grid gp = gpm.get(e);
        Move mp = mpm.get(e);

        if (!mp.moving) return;

        mp.currentTime += world.getDelta();
        vec.set(gp.x, gp.y, 0);
        IsoSystem.gridToWorld(vec);
        vec.add(IsoSystem.GRID_SIZE_X / 2, - IsoSystem.GRID_SIZE_Y / 2f, 0);
        if ((mp.currentTime - mp.startTime) > 2f) {
            mp.x = vec.x;
            mp.y = vec.y;
            mp.moving = false;
        } else {
            float alpha = (mp.currentTime - mp.startTime) / 2f;
            mp.x = mp.oldX + (vec.x - mp.oldX) * alpha;
            mp.y = mp.oldY + (vec.y - mp.oldY) * alpha;
        }
    }
}
