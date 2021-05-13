package com.ivs.tws.Map.Model.Map.tmx;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.ivs.tws.Map.Model.Map.gataway.TiledMapGateway;


/**
 * Created by emmanuel_payet on 28/04/15.
 */
public class LibgdxTmxMapLoader implements ITmxMapLoader{
    @Override
    public TiledMapGateway load(String path) {
        TiledMap tiledMap = new TmxMapLoader().load(path);

        return new TiledMapGateway(tiledMap);
    }
}
