package com.gameofcode.entity;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
	
	private int lives;
	private int energy;
	

	public Player(String path) {
		super(path);
		lives = 3;
		energy = 100;
	}

	@Override
	public void render(SpriteBatch batch) {
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	



	
}
