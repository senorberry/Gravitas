package com.berry.gravitas.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.berry.gravitas.GravitasGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	      config.title = "Gravitas";
	      config.width = 800;
	      config.height = 480;
		new LwjglApplication(new GravitasGame(), config);
	}
}
