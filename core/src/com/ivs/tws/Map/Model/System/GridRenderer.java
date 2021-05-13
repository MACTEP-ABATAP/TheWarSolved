package com.ivs.tws.Map.Model.System;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.math.Vector2;
import com.ivs.tws.Map.Model.GlobalCfg;
import com.ivs.tws.Map.Model.Manager.CameraManager;
import com.ivs.tws.Map.Model.Manager.SpriteBatchManager;
import com.ivs.tws.Map.Model.Map.Iso.IsoHelper;
import com.ivs.tws.Map.Model.Map.Iso.IsoTile;
import com.ivs.tws.Map.Model.components.MapComponent;

public class GridRenderer extends EntityProcessingSystem {
    SpriteBatchManager spriteBatchManager;
    CameraManager cameraManager;
    ComponentMapper<MapComponent> mapComponentMapper;
    

    public GridRenderer() {
        super(Aspect.all(MapComponent.class));
    }

    @Override
    protected void begin() {
        super.begin();
        cameraManager.camera.update();
        spriteBatchManager.spriteBatch.setProjectionMatrix(cameraManager.camera.combined);
        spriteBatchManager.spriteBatch.begin();
    }

    @Override
    protected void process(Entity e) {
        MapComponent mapComponent = mapComponentMapper.get(e);
        int h = mapComponent.mapHeight;
        int w = mapComponent.mapWidth;
        for(int y = h-1;y >= 0 ;y--){
            for(int x = 0; x < w;x++){
                IsoTile tile = mapComponent.getTile(x,y);
                if(tile != null){
                    Vector2 position = IsoHelper.toWorldCoord(x, y, tile.height, GlobalCfg.TILE_W, GlobalCfg.TILE_H, GlobalCfg.TILE_DEPTH);
                    //System.out.print("1, ");
                    spriteBatchManager.spriteBatch.draw(tile.texture, position.x , position.y);
                }else {
                    //System.out.print("0, ");
                }
            }
            //System.out.println("");
        }
        //System.out.println("================================");
    }


    @Override
    protected void end() {
        super.end();
        spriteBatchManager.spriteBatch.end();
    }
}
