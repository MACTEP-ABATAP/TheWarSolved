package com.ivs.tws.Model.System;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ivs.tws.Model.GlobalCfg;
import com.ivs.tws.Model.Map.Iso.IsoCamera;
import com.ivs.tws.Model.Map.Iso.IsoHelper;
import com.ivs.tws.Model.Map.Iso.IsoTile;
import com.ivs.tws.Model.components.MapComponent;

public class GridRenderer extends EntityProcessingSystem {
    SpriteBatch spriteBatch;
    IsoCamera isoCamera;
    ComponentMapper<MapComponent> mapComponentMapper;
    

    public GridRenderer() {
        super(Aspect.all(MapComponent.class));
    }

    @Override
    protected void begin() {
        super.begin();
        isoCamera.update();
        spriteBatch.setProjectionMatrix(isoCamera.combined);
        spriteBatch.begin();
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
                    spriteBatch.draw(tile.texture, position.x , position.y);
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
        spriteBatch.end();
    }
}
