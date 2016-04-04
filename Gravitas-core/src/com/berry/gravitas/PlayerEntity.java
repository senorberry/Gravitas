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
		if (Gdx.input.isKeyPressed(Keys.LEFT)){
	           
			Action a = new Movement(this, new Vector2(this.pos.x-1,
					this.pos.y), loc );
			a.perform();}
			if (Gdx.input.isKeyPressed(Keys.RIGHT)){
	    		Action a = new Movement(this, new Vector2(this.pos.x+1,
	    				this.pos.y), loc );
	    		a.perform();}
	        if (Gdx.input.isKeyPressed(Keys.UP)){
	          
	       		Action a = new Movement(this, new Vector2(this.pos.x,
	    				this.pos.y+1), loc );
	    		a.perform();
	        }
	        if (Gdx.input.isKeyPressed(Keys.DOWN)){
	       		Action a = new Movement(this, new Vector2(this.pos.x,
	    				this.pos.y-1), loc );
	    		a.perform();
	            
	            
	        }
	}

}
