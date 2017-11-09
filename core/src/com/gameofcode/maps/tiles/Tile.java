package com.gameofcode.maps.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class Tile extends StaticTiledMapTile {


	public Tile(int id, TextureRegion textureRegion)
	{
		super(textureRegion);
		this.textureRegion = textureRegion;
		this.id = id;
		this.isReachable = false;
		// TODO Auto-generated constructor stub
	}
	
	public static final int WIDTH = 32;
	public static final int HEIGHT= 32;
	private TextureRegion textureRegion; 
	private boolean isReachable;
	private int id;
	public static Tile floor = new FloorTile(1, 32, 32);
	public static Tile wall = new WallTile(2,32,32);

}
