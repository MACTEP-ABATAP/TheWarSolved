package com.ivs.tws.Map.Model.Map.tmx;


import com.ivs.tws.Map.Model.Map.gataway.TiledMapGateway;

/**
 * Created by emmanuel_payet on 28/04/15.
 */
public interface ITmxMapLoader {
    TiledMapGateway load(String path);
}
