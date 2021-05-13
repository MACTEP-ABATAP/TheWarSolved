package com.ivs.tws.Map.Model.Manager;

import com.artemis.Manager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ivs.tws.Map.Model.GlobalCfg;


public class CameraManager extends Manager {
    public OrthographicCamera camera;

    public CameraManager(){
        camera = new OrthographicCamera(GlobalCfg.VIEWP_W, GlobalCfg.VIEWP_H);
    }
}
