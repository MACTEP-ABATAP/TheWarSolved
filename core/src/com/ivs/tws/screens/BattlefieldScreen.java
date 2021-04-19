package com.ivs.tws.screens;


import com.ivs.tws.MyGame;
import com.ivs.tws.screens.ScreenUtil.AbstractScreen;

public class BattlefieldScreen extends AbstractScreen {

    public void createUI (){

    }
    @Override
    public void create(){

    }


    // Current level
    private int level;


    public BattlefieldScreen(Integer level) {
        super();
        this.level = level.intValue();

    }

    @Override
    public void buildStage() {
        // Adding actors






    }

    @Override
    public void dispose() {

    }


}
