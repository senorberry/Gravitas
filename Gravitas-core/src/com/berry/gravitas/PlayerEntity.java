package com.berry.gravitas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class PlayerEntity extends Entity {
	
	public PlayerEntity(Vector2 v, Location l) {
		super(v,l);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(){
        /*if (Gdx.input.isKeyPressed(Keys.LEFT))
            pos.x -= 1;//10 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            pos.x += 1;//10 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.UP))
            pos.y += 1;//10 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.DOWN))
            pos.y -= 1;//10 * Gdx.graphics.getDeltaTime();
        */
	}

}
