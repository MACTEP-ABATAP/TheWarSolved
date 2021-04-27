package com.ivs.tws.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Align;
import com.ivs.tws.Maps.MapTile;
import com.ivs.tws.screens.ScreenUtil.AbstractScreen;
import com.ivs.tws.screens.ScreenUtil.ScreenEnum;
import com.ivs.tws.screens.ScreenUtil.UIFactory;

import java.util.Map;

public class LevelSelectScreen extends AbstractScreen {
    private Texture txtrBg;
    private Texture txtrBack;
    private Texture txtrLevel1;
    private Texture txtrLevel2;

    public LevelSelectScreen() {
        super();
        txtrBg   = new Texture( Gdx.files.internal("img/Play.png") );
        txtrBack = new Texture( Gdx.files.internal("img/Play.png") );
        txtrLevel1 = new Texture( Gdx.files.internal("img/Play.png") );
        txtrLevel2 = new Texture( Gdx.files.internal("img/Play.png") );
    }

    @Override
    public void create() {

    }

    @Override
    public void buildStage() {

        // Adding actors
        Image bg = new Image(txtrBg);
        addActor(bg);

        ImageButton btnBack = UIFactory.createButton(txtrBack);
        btnBack.setPosition(260.f, 40.f, Align.center);
        addActor(btnBack);

        ImageButton btnLevel1 = UIFactory.createButton(txtrLevel1);
        btnLevel1.setPosition(100.f, 100.f, Align.center);
        addActor(btnLevel1);

        ImageButton btnLevel2 = UIFactory.createButton(txtrLevel2);
        btnLevel2.setPosition(220.f, 100.f, Align.center);
        addActor(btnLevel2);

        btnBack.addListener( UIFactory.createListener( ScreenEnum.MAIN_MENU ) );
        btnLevel1.addListener( UIFactory.createListener(ScreenEnum.GAME, 1) );
        btnLevel2.addListener( UIFactory.createListener(ScreenEnum.GAME, 2) );
    }

    @Override
    protected Texture mapTextures() {
        return null;
    }

    @Override
    protected Map<Integer, MapTile> createTiles() {
        return null;
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void dispose() {
        super.dispose();
        txtrBg.dispose();
        txtrBack.dispose();
        txtrLevel1.dispose();
        txtrLevel2.dispose();
    }
}
