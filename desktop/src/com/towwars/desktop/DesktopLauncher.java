package com.towwars.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.towwars.TWarsGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 1000;
        config.width = 1000;
        config.title = "Z O M G !!!";
		new LwjglApplication(new TWarsGame(), config);
	}
}
