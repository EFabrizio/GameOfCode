package com.gameofcode;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Gdx;
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
import com.gameofcode.exceptions.AnalyzerException;
import com.gameofcode.lexer.Lexer;
import com.gameofcode.parser.Parser;
import com.gameofcode.parser.Rule;
import com.gameofcode.token.Token;

public class GameScreen implements Screen {
	
	private GameApp gameApp;
	private SpriteBatch batch;
	private Texture img;
	private TextureRegion boxCut;
	private Stage stage;
	private Skin skin;
	private TextArea textAreaCode;
	private TextButton button;
	private Player player;
	private OrthogonalTiledMapRenderer mapRender;
	private OrthographicCamera camera;
	
	public GameScreen(GameApp gameApp){
		this.gameApp = gameApp;
		batch = new SpriteBatch();
		stage = new Stage(new StretchViewport(Settings.HEIGHT,Settings.WIDTH));



		player = new Player();
		img = new Texture("boy.png");
		
		boxCut = new TextureRegion(img,0,0,42,50);
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		   
			textAreaCode = new TextArea("",skin);
			textAreaCode.setPosition(350,0);
			textAreaCode.setSize(250, 950);
			
			
		   button = new TextButton("Ejecutar Programa", skin);
		button.setSize(250, 75);
		button.setPosition(350, 0);
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
		mapRender.setView(camera);
		mapRender.render();
		batch.begin();
		batch.draw(boxCut, 350, 0);
		batch.end();
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		stage.dispose();
		mapRender.dispose();
	}

	@Override
	public void show() {
		mapRender = new OrthogonalTiledMapRenderer(new LevelMap(64,64));
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		this.camera = new OrthographicCamera(w, h);
		this.camera.setToOrtho(false, w, h);
		camera.position.set(70,300, 0);

		
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

	

}
