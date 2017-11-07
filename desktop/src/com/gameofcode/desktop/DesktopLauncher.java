package com.gameofcode.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gameofcode.GameApp;
import com.gameofcode.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Settings.TITLE;
		config.height = Settings.HEIGHT;
		config.width = Settings.WIDTH;
		new LwjglApplication(new GameApp(), config);
	}
}
