package com.berry.gravitas;

import com.badlogic.gdx.math.Vector2;

abstract class Action {

	protected Entity performer;
	protected Vector2 loc;

	

	public Action(Entity e){
		
		this.performer = e;
		this.loc = e.pos.cpy();
		
	}
	
	abstract boolean perform();
	
	public Entity getPerformer() {
		return performer;
	}
	
	public Vector2 getLocation(){
		return loc;
	}
}
