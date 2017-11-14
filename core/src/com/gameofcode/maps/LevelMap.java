package com.gameofcode.maps;

import java.util.Random;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.gameofcode.maps.tiles.Tile;

public class LevelMap extends TiledMap {
	
	private TiledMapTileLayer tileLayer;
	private int width, height;
	private Array<Rectangle> collisionTiles = new Array<Rectangle>();


	private Texture tileLayerTexture;
	private int[][] noiseMap;
	
	public LevelMap(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.tileLayer = new TiledMapTileLayer(width, height, Tile.WIDTH, Tile.HEIGHT);
		this.noiseMap = new int[width][height];
		this.initLevelMap();
		
	}

	private void initLevelMap() {
		MapLayers layers = this.getLayers();
		Random random = new Random();
				for (int x = 0; x < width; x++) {
					for (int y = 0; y < height; y++) {
						Cell cell = new Cell();
						if(random.nextInt(2) == 1) {
						cell.setTile(Tile.floor);
						}else {
						cell.setTile(Tile.wall);
						collisionTiles.add(new Rectangle(x*Tile.WIDTH,y*Tile.HEIGHT,Tile.WIDTH,Tile.HEIGHT));
						}
						tileLayer.setCell(x, y, cell);
						
					}
				}
					

		
			layers.add(this.tileLayer);
	}
	
	public Array<Rectangle> getCollisionTiles() {
		return collisionTiles;
	}	

}
