package com.ivs.tws;

import android.os.Bundle;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ivs.tws.controller.MyGameCallback;
import com.ivs.tws.screens.BattlefieldScreen;
import com.ivs.tws.screens.MainMenuScreen;
import com.ivs.tws.screens.MyGame;
import com.ivs.tws.screens.ScreenUtil.AbstractScreen;

public class AndroidLauncher extends AndroidApplication{





	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;
		config.useWakelock = true;
		initialize(new MyGame(), config);
	}



}
