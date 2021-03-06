package com.ivs.tws;

import android.os.Bundle;


import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ivs.tws.core.SpaceshipWarrior;


public class AndroidLauncher extends AndroidApplication{





	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;
		config.useWakelock = true;

		config.useGL30 = true;

		initialize(new SpaceshipWarrior(), config);
	}



}
