package com.gameofcode.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Monster extends Entity{

	public Monster(String path) {
		super(path);
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(texture,position.x,position.y);
	}

	@Override
	public void update(float delta) {}

}
