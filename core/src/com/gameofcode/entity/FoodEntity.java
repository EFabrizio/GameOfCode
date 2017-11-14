package com.gameofcode.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FoodEntity extends Entity {

	private boolean drinkeable;
	
	public boolean isDrinkeable() {
		return drinkeable;
	}

	public FoodEntity(String path,boolean canDrink) {
		super(path);
		this.drinkeable = canDrink;
		
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x, position.y);		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		
	}

	

}
