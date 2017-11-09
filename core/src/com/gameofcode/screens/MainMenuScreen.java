package com.gameofcode.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gameofcode.GameApp;
import com.gameofcode.Settings;

public class MainMenuScreen implements Screen{
	
	private GameApp gameApp;
	private Stage stage;
	
	public MainMenuScreen(GameApp gameApp) {
		this.gameApp = gameApp;
		stage = new Stage(new StretchViewport(Settings.HEIGHT,Settings.WIDTH));
		TextButton buttonPlay = new TextButton("Jugar",gameApp.skin);
		TextButton buttonAbout = new TextButton("Acerca de",gameApp.skin);
		buttonPlay.setPosition(250, 400);
		buttonPlay.setSize(100, 100);
		buttonAbout.setSize(100, 100);
		buttonAbout.setPosition(250,250);
		stage.addActor(buttonPlay);
		stage.addActor(buttonAbout);
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	
		gameApp.batch.begin();
		gameApp.batch.end();
		if (Gdx.input.isTouched()) {
			gameApp.setScreen(new GameScreen(gameApp));
			dispose();
		}
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}
