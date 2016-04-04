package com.berry.gravitas;



import java.io.IOException;
import java.io.InputStream;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Location {
	
	public int[] tiles;
	private int height, width;
    Texture tileset;
    TextureRegion[] region;
	
	public Location(String fileName){


		

		try {
			
			FileHandle file = Gdx.files.local(fileName);
			InputStream text = file.read();
			int i,j;
			j=0;
			this.height=text.read();
			//text.read();
			this.width=text.read();
			//text.read();
			this.tiles = new int[width*height*5];
			
			while ((i = text.read()) != -1){
			       
			    	   tiles[j]=i;
			       j++;
			    }
			
			text.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
        tileset = new Texture(Gdx.files.internal("Tiles.png"));
        region = new TextureRegion[5];
        
        for(int i =0; i<5; i++){
        	region[i] = new TextureRegion(tileset, 5*i, 0, 5, 5);
        }
		
		

		
	}
	
	public Location(int x, int y){

		this.height=y;
		this.width=x;
		tiles=new int[width*height*5];
		
			
			
			
			
			
	        tileset = new Texture(Gdx.files.internal("Tiles.png"));
	        region = new TextureRegion[5];
	        
	        for(int i =0; i<5; i++){
	        	region[i] = new TextureRegion(tileset, 5*i, 0, 5, 5);
	        }
			
		
	}
	
	public int getHeight(){return height;}
	public int getWidth(){return width;}
	
	
	public int getTile(int i, int j, int k){

		return tiles[i+j*width+k*height*width];
	}
	
	public TextureRegion getTexture(int i, int j, int k){
		if(i+j*width+k*height*width<width*height*5 && i+j*width+k*height*width>=0){
		return region[tiles[i+j*width+k*height*width]];}
		else {return region[0];}
	}
	
	

}
