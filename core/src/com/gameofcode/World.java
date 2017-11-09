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
	
	private Player player;
	private LevelMap map;
	private List<Entity> entities;
	private OrthogonalTiledMapRenderer mapRender;
	private OrthographicCamera camera;
	private Random random = new Random();
	private FoodEntity food = new FoodEntity("entities/pizza.png");
	
	public World() {
		player = new Player("entities/pizza.png");
		entities = new ArrayList<Entity>();
		food.setPositionByTile(10, 5);
		for(int i = 0 ; i < 10;i++) {
			entities.add(
					new FoodEntity("entities/pizza.png"));
			entities.get(i).setPositionByTile(random.nextInt(10),random.nextInt(15));
		}
		map = new LevelMap(18,19);
		mapRender = new OrthogonalTiledMapRenderer(map);
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		this.camera = new OrthographicCamera(w, h);
		this.camera.setToOrtho(false, w, h);
	}
	
	
	public void render(SpriteBatch batch) {
		mapRender.render();
		for(Entity entity:entities) {
			entity.render(batch);
		}
		food.render(batch);
	}
	
	public void update(float delta) {
		mapRender.setView(camera);
		player.update(Gdx.graphics.getDeltaTime());
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			camera.position.x-=3;
			camera.update();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.position.x+=3;
			camera.update();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			camera.position.y-=3;
			camera.update();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			camera.position.y+=3;
			camera.update();
		}
		System.out.println(camera.position.x);
		System.out.println(camera.position.y);
	}

	public void dispose() {
		mapRender.dispose();
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
