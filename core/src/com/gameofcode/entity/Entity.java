package com.gameofcode.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity {
	
	protected Animation animation;
	protected Texture textureImage;
	protected TextureRegion[] animationFrames;
	protected Vector2 position;
	protected Vector2 velocity;
	protected Texture texture;
	protected TextureRegion[] textureRegion;
	protected final int HEIGHT = 32;
	protected final int WIDTH = 32;
	
	
	public Entity() {}
	
	public Entity(String path) {
		texture = new Texture(path);
		position = new Vector2(0,0);
		velocity = new Vector2();
		//extureRegion = new TextureRegion(texture,0,0,42,50);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void setPosition(int x,int y) {
		position.x = x;
		position.y = y;
	}
	
	public void setPositionByTile(int x, int y) {
		position.x = x*32;
		position.y = y*32;
	}
	
	protected void loadTextureRegion(FileHandle file) {
		
	}
	
	
	public abstract void render(SpriteBatch batch);
	public abstract void update(float delta);
	public abstract void dispose();

}
