package com.gameofcode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenuScreen implements Screen{
	
	private GameApp gameApp;

	public MainMenuScreen(GameApp gameApp) {
		this.gameApp = gameApp;
		TextButton buttonPlay = new TextButton("Jugar",gameApp.skin);
		TextButton buttonAbout = new TextButton("Acerca de",gameApp.skin);
		buttonPlay.setPosition(250, 400);
		buttonPlay.setSize(100, 100);
		buttonAbout.setSize(100, 100);
		buttonAbout.setPosition(250,250);
		gameApp.stage.addActor(buttonPlay);
		gameApp.stage.addActor(buttonAbout);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
		gameApp.stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		gameApp.stage.draw();
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
		// TODO Auto-generated method stub
		
	}

}
