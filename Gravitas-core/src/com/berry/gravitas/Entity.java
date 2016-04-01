package com.berry.gravitas;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Entity {

	public Vector2 pos;
	


	public Entity(){
		this.pos= new Vector2(5,5);
		
	}
	
	public void update(){
        if (Gdx.input.isKeyPressed(Keys.LEFT))
            pos.x -= 10 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            pos.x += 10 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.UP))
            pos.y += 10 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.DOWN))
            pos.y -= 10 * Gdx.graphics.getDeltaTime();
		
		
	}
	

	/*public Vector2 getPos() {
		return pos;
	}

	public void setPos(float x, float y) {
		this.pos.set(x, y);
	}*/
	
	
	
}
