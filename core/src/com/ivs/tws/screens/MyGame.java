package com.ivs.tws.screens;

import com.badlogic.gdx.Game;
import com.ivs.tws.screens.ScreenUtil.ScreenEnum;
import com.ivs.tws.screens.ScreenUtil.ScreenManager;

public class MyGame extends Game {
    @Override
    public void create() {
        ScreenManager.getInstance().initialize(this);
        ScreenManager.getInstance().showScreen( ScreenEnum.MAIN_MENU);
    }
}
