package com.gameofcode.screens;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
import com.gameofcode.World;
import com.gameofcode.compiler.exceptions.AnalyzerException;
import com.gameofcode.compiler.lexer.Lexer;
import com.gameofcode.compiler.parser.Parser;
import com.gameofcode.compiler.parser.Rule;
import com.gameofcode.compiler.token.Token;
import com.gameofcode.entity.FoodEntity;
import com.gameofcode.entity.Player;
import com.gameofcode.maps.LevelMap;

public class GameScreen implements Screen {
	
	private GameApp gameApp;
	private Stage stage;
	private Skin skin;
	private TextArea textAreaCode;
	private TextButton button;
	private World world;

	
	public GameScreen(GameApp gameApp){
		this.gameApp = gameApp;
		stage = new Stage(new StretchViewport(Settings.HEIGHT,Settings.WIDTH));
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		world = new World();
		textAreaCode = new TextArea("",skin);
		textAreaCode.setPosition(360,0);
		textAreaCode.setSize(240, 950);
		button = new TextButton("Ejecutar Programa", skin);
		button.setSize(240, 75);
		button.setPosition(360, 0);
		button.addListener(new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
				Lexer lexer = new Lexer();
				Parser parser = new Parser();
				try {
					//usernameTextField.setText("");
					//syntaxArea.setText("");
					
					// lexer
					String sourceCode = textAreaCode.getText();
					lexer.tokenize(sourceCode);

					
					// parser
					File grammarFile = Gdx.files.internal("data/grammar.txt").file();
					parser.parse(grammarFile, lexer.getFilteredTokens());


				} catch (AnalyzerException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (FileNotFoundException fileNotFoundException) {
					JOptionPane.showMessageDialog(null, "File with grammar is not found!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					int i = 0;
					String message ="";
					for (Token token : lexer.getTokens()) {
						if (token.getTokenType().isAuxiliary())
							message +="   " + token.toString() + "\n";
						else {
							i++;
							message+= (i + "   " + token.toString() + "\n");
						}
					}
					
					for (Rule r : parser.getSequenceOfAppliedRules()) {
						//syntaxArea.append(r.toString() + "\n");
					}
					System.out.println(message);
				}
		    }
		});


		stage.addActor(textAreaCode); 
		stage.addActor(button);
		Gdx.input.setInputProcessor(stage);
		
	}



	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameApp.batch.begin();
		world.render(gameApp.batch);
		gameApp.batch.end();
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		world.update(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
		gameApp.batch.dispose();
		stage.dispose();
		world.dispose();
	}

	@Override
	public void show() {
		
	}


	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	

}
