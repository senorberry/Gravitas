package com.berry.gravitas;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Entity implements Tickable{

	public Vector2 pos;
	protected Location loc;


	public Entity(Vector2 v,Location l){
		this.pos= v;
		this.loc = l;
	}
	
	public void update(){
		Action a = new Movement(this, new Vector2(pos.x,pos.y-1), loc );
		a.perform();
		
	}
	

	/*public Vector2 getPos() {
		return pos;
	}

	public void setPos(float x, float y) {
		this.pos.set(x, y);
	}*/
	
	
	
}
