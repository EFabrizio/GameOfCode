package com.gameofcode.ui;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gameofcode.entity.Entity;
import com.gameofcode.entity.FoodEntity;
import com.gameofcode.entity.Player;

public class Inventory {
	
	private Texture inventorySprite;
	private List<FoodEntity>items = new ArrayList<FoodEntity>();
	private Player player;

	public Inventory(Player player) {
		this.player = player;
		inventorySprite = new Texture("ui/inventory.png");
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(inventorySprite, 220, 550);
		for(Entity inventoryItems: items) {
			inventoryItems.render(batch);
		}
		
	}
	public void update(float delta) {
		
	}

	public void dispose() {
		inventorySprite.dispose();
	}
	
	public void addItem(FoodEntity food) {
		items.add(food);
		food.setPosition(185 + (items.size() * 36), 555);
	}
	
	
	public void eatItem(int position) {
		if(position >= 0 && position <= 5) {
		FoodEntity food = items.get(position);
		if(food.isDrinkeable()){
		items.remove(position);
		} else {
			//MANDAR ERROR SEMANTICO.
			System.out.println("CANT EAT A DRINKEABLE FOOD.");
		}
	} else {
		//MANDAR ERROR SEMANTICO.
		
	}
}
	
	public void drinkItem(int position) {
		if(position >= 0 && position <= 5) {
		FoodEntity food = items.get(position);
		if(!food.isDrinkeable()){
		items.remove(position);
		} else {
			//MANDAR ERROR SEMANTICO.
			System.out.println("CANT EAT A DRINKEABLE FOOD.");
		}
	} else {
		//MANDAR ERROR SEMANTICO.
		
	}
}
	
	

}
