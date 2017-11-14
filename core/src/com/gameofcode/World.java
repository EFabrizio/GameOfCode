package com.gameofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.gameofcode.entity.Entity;
import com.gameofcode.entity.FoodEntity;
import com.gameofcode.entity.Player;
import com.gameofcode.maps.LevelMap;

public class World {
	
	private GameApp gameApp;
	private Player player;
	private LevelMap map;
	private List<Entity> entities;
	private OrthogonalTiledMapRenderer mapRender;
	private OrthographicCamera camera;
	private Random random = new Random();
	public World(GameApp gameApp) {
		this.gameApp = gameApp;
		player = new Player(gameApp,this);
		player.getInventory().addItem(new FoodEntity("entities/water.png",true));
		
		player.getInventory().addItem(new FoodEntity("entities/water.png",true));
		player.getInventory().addItem(new FoodEntity("entities/water.png",true));
		player.getInventory().addItem(new FoodEntity("entities/water.png",true));
		player.getInventory().addItem(new FoodEntity("entities/pizza.png",false));
		player.getInventory().addItem(new FoodEntity("entities/pizza.png",false));
		//player.getInventory().eatItem(1);
		entities = new ArrayList<Entity>();
		for(int i = 0 ; i < 10;i++) {
			if(random.nextInt(2) == 1)
			entities.add(
					new FoodEntity("entities/pizza.png",false));
			else
				entities.add(
						new FoodEntity("entities/water.png",true));
			entities.get(i).setPositionByTile(random.nextInt(10),random.nextInt(15));
		}
		map = new LevelMap(18,17);
		mapRender = new OrthogonalTiledMapRenderer(map);
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		this.camera = new OrthographicCamera(w, h);
		this.camera.setToOrtho(false, w, h);
	}
	
	
	public void render(SpriteBatch batch) {
		for(Entity entity:entities) {
			entity.render(batch);
		}
		player.render(batch);

	}
	
	public void update(float delta) {
		mapRender.setView(camera);
		player.update(Gdx.graphics.getDeltaTime());
	}

	public void dispose() {
		mapRender.dispose();
		player.dispose();
	}
	
	public Player getPlayer() {
		return player;
	}


	public void renderMap() {
		mapRender.render();		
	}
	
	
	public LevelMap getMap() {
		return map;
	}
}
