package com.gameofcode.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gameofcode.entity.Player;

public class EnergyBar {
	
	private Texture overlay;
	private Texture mana;
	private Texture health;
	private Player player;

	public EnergyBar(Player player) {
		this.player = player;
		overlay = new Texture("ui/overlay.png");
		mana = new Texture("ui/mana.png");
		health = new Texture("ui/health.png");
	}
	
	public void render(SpriteBatch batch) {
		if(player.getLives() >= 0 && player.getLives() <= 3)
		batch.draw(health,25,560,55 * player.getLives(),24);
		if(player.getEnergy()>= 0 && player.getEnergy() <= 165)
		batch.draw(mana, 24, 548,player.getEnergy(),8);
		batch.draw(overlay, 20, 538);
		
		
	}
	public void update(float delta) {
		
	}

	public void dispose() {
		overlay.dispose();
		mana.dispose();
		health.dispose();
	}

}
