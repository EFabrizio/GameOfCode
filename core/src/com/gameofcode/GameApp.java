package com.gameofcode;

import java.io.File;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gameofcode.exceptions.AnalyzerException;
import com.gameofcode.lexer.Lexer;
import com.gameofcode.parser.Parser;
import com.gameofcode.parser.Rule;
import com.gameofcode.token.Token;



public class GameApp extends Game {
	
	public SpriteBatch batch;
	public BitmapFont font;
	public Skin skin;
	public Stage stage;

	@Override
	public void create() {
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		stage = new Stage(new StretchViewport(Settings.HEIGHT,Settings.WIDTH));
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
		
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	public void dispose() {
		batch.dispose();
		stage.dispose();
		font.dispose();
	}
	
	
}
