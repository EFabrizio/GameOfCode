package com.gameofcode.maps.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class FloorTile extends Tile {

	public FloorTile(int id, int xIndex, int yIndex){
		super(id, new TextureRegion(new Texture(Gdx.files.internal("maps/tileset.png")),192,64,xIndex,yIndex));
		
	}

}
