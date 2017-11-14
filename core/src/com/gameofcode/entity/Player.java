package com.gameofcode.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gameofcode.GameApp;
import com.gameofcode.World;
import com.gameofcode.screens.GameOverScreen;
import com.gameofcode.ui.EnergyBar;
import com.gameofcode.ui.Inventory;

public class Player extends Entity {
	
	private GameApp gameApp;
	private int lives;
	private int energy;
	private EnergyBar energyBar;
	private Inventory inventory;
	private Rectangle bound;
	private World world;
	private final float RUNNING_VELOCITY = 1.5f;
	private final float DAMPING = 0.87f;
	/**
	 * Collision detection.
	 */
	private int startX,endX,startY,endY;
	
	public Player(GameApp gameApp,World world) {
		this.world = world;
		this.gameApp = gameApp;
		position = new Vector2(300,300);
		velocity = new Vector2();
		texture = new Texture("entities/boy.png");
		textureRegion = TextureRegion.split(texture, 44,50)[0];
		bound = new Rectangle(position.x,position.y,26,26);		
		energyBar = new EnergyBar(this);
		inventory = new Inventory(this);
		//ENERGIA MAXIMA ES 165
		energy = 30;
		lives = 3;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(textureRegion[0], position.x,position.y,HEIGHT,WIDTH);
		energyBar.render(batch);
		inventory.render(batch);
	}

	@Override
	public void update(float delta) {
		if (delta == 0) return;

		if (delta > 0.1f)
			delta = 0.1f;
		
		bound.x = position.x;
		bound.y = position.y;
		startX = (int) position.x;
		endX = (int) (position.x + WIDTH);
		startY = (int) position.y;
		endY = (int) (position.y + HEIGHT);
		
		
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			velocity.x = RUNNING_VELOCITY;
		}		
		
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			velocity.x= -RUNNING_VELOCITY;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			velocity.y= RUNNING_VELOCITY;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			velocity.y= -RUNNING_VELOCITY;
		}
		

		for(Rectangle rectangle:world.getMap().getCollisionTiles()) {
			if(rectangle.overlaps(bound)) {
			//velocity.x = 0;
			//position.x-=1f;
			System.out.println("CRASH");
			}
		}
		
		if(energy == 0) {
			this.gameApp.setScreen(new GameOverScreen(gameApp));
		}
		
		if (Math.abs(velocity.x) < 1) {
			velocity.x = 0;
		}
		if (Math.abs(velocity.y) < 1) {
			velocity.y = 0;
		}
		
		
		velocity.x = MathUtils.clamp(velocity.x, -RUNNING_VELOCITY, RUNNING_VELOCITY);
		velocity.y = MathUtils.clamp(velocity.y, -RUNNING_VELOCITY, RUNNING_VELOCITY);
		velocity.scl(delta);		
		velocity.scl(1/delta);
		position.add(velocity);
		velocity.x *= DAMPING;
		velocity.y *= DAMPING;
		
	}

	public int getLives() {
		return lives;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	@Override
	public void dispose() {
		this.texture.dispose();
		energyBar.dispose();
		inventory.dispose();
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	



	
}
