package com.gameofcode.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WallTile extends Tile {

	public WallTile(int id, int xIndex, int yIndex) {
		super(id, new TextureRegion(new Texture(Gdx.files.internal("tileset2.png")),192,128,xIndex,yIndex));
		
	}

}
