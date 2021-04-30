package com.ivs.tws.screens;



//public class MainMenuScreen extends AbstractScreen {
//    private OrthographicCamera camera;
//    private Texture txtrBg;
//    private Texture txtrPlay;
//    private Texture txtrExit;
//
//
//    public MainMenuScreen() {
//        super();
//        camera = new OrthographicCamera();
//        txtrBg   = new Texture( Gdx.files.internal("img/badlogic.png") );
//        txtrPlay = new Texture( Gdx.files.internal("img/Play.png") );
//        txtrExit = new Texture( Gdx.files.internal("img/BurntOrange") );
//    }
//
//    @Override
//    public void create() {
//        camera = new OrthographicCamera();
//    }
//
//    @Override
//    public void buildStage() {
//        camera = new OrthographicCamera();
//        Image bg = new Image(txtrBg);
//        addActor(bg);
//
//        ImageButton btnPlay = UIFactory.createButton(txtrPlay);
//        btnPlay.setPosition(getWidth() / 2, 120.f, Align.center);
//        addActor(btnPlay);
//
//        ImageButton btnExit = UIFactory.createButton(txtrExit);
//        btnExit.setPosition(getWidth() / 2, 60.f, Align.bottom);
//        addActor(btnExit);
//
//        btnPlay.addListener( UIFactory.createListener(ScreenEnum.LEVEL_SELECT) );
//
//        btnExit.addListener(
//                new InputListener() {
//                    @Override
//                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                        Gdx.app.exit();
//                        return false;
//                    }
//                });
//    }
//
//    @Override
//    protected Texture mapTextures() {
//        return null;
//    }
//
//    @Override
//    protected Map<Integer, MapTile> createTiles() {
//        return null;
//    }
//
//    @Override
//    public void render(float delta) {
//
//    }
//
//    @Override
//    public void dispose() {
//        super.dispose();
//        txtrBg.dispose();
//        txtrPlay.dispose();
//        txtrExit.dispose();
//    }
//}
