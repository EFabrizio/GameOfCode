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
import com.gameofcode.compiler.exceptions.AnalyzerException;
import com.gameofcode.compiler.lexer.Lexer;
import com.gameofcode.compiler.parser.Parser;
import com.gameofcode.compiler.parser.Rule;
import com.gameofcode.compiler.token.Token;
import com.gameofcode.screens.MainMenuScreen;



public class GameApp extends Game {
	
	public SpriteBatch batch;
	public Skin skin;

	@Override
	public void create() {
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
		
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	public void dispose() {
		batch.dispose();
	}
	
	
}
