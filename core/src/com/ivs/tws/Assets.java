package com.ivs.tws;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    public static AssetManager manager;

    public String texture;

    private static Assets instance;

    //Not synchronized
    public static Assets instance() {
        if (instance == null) {
            instance = new Assets();
        }
        return instance;
    }

    private Assets() {
        manager = new AssetManager();
    }

    public void loadLoaderAssets() {
        manager.load(texture, Texture.class);
    }

    public static void clear() {
        Assets.manager.clear();
    }

//    public static final String rocketTexture = "data/rocket/rocket.png";
//
//    public void loadRocketAssets() {
//        manager.load(rocketTexture, Texture.class);
//    }
//
//
//
//    public void disposeRocketAssets() {
//        manager.unload(rocketTexture);
//    }

    public void disposeLoaderAssets() {
        manager.unload(texture);
    }

    public static final String BG0_0 = "assets/grass";


    public void loadBGAssets() {
        manager.load(BG0_0, Texture.class);
    }

    public void disposeBGAssets() {
        manager.unload(BG0_0);
    }

    public void loadGameAssets() {
        //loadRocketAssets();
        loadBGAssets();
    }

    public void disposeGameAssets() {
        //disposeRocketAssets();
        disposeBGAssets();
    }


}
