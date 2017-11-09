package com.gameofcode.screens;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gameofcode.GameApp;
import com.gameofcode.Settings;
import com.gameofcode.compiler.exceptions.AnalyzerException;
import com.gameofcode.compiler.lexer.Lexer;
import com.gameofcode.compiler.parser.Parser;
import com.gameofcode.compiler.parser.Rule;
import com.gameofcode.compiler.token.Token;
import com.gameofcode.maps.LevelMap;

public class GameOverScreen implements Screen {
	
	private GameApp gameApp;
	private Stage stage;
	private TextButton playAgain;
	private BitmapFont fontText;
	
	public GameOverScreen(GameApp gameApp){
		this.gameApp = gameApp;
		stage = new Stage(new StretchViewport(Settings.HEIGHT,Settings.WIDTH));
		playAgain = new TextButton("Jugar de nuevo",gameApp.skin);
		stage.addActor(playAgain);
	}



	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameApp.batch.begin();
		//gameApp.batch.draw(, 350, 0);
		gameApp.batch.end();
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	
	}
	
	@Override
	public void dispose () {
		gameApp.batch.dispose();
	}

	@Override
	public void show() {}


	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	

}
