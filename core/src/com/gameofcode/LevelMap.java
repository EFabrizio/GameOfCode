package com.gameofcode;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.gameofcode.maps.Tile;

public class LevelMap extends TiledMap {
	
	private TiledMapTileLayer tileLayer;
	private int width, height;
	

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
				for (int x = 0; x < 64; x++) {
					for (int y = 0; y < 64; y++) {
						Cell cell = new Cell();
						if(random.nextInt(2) == 1)
						cell.setTile(Tile.floor);
						else
						cell.setTile(Tile.wall);
						tileLayer.setCell(x, y, cell);
					}
				}
					

		
			layers.add(this.tileLayer);
	}

}
