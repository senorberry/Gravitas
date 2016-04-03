package com.berry.gravitas;

import com.badlogic.gdx.math.Vector2;

public class Movement extends Action {

	Vector2 endLoc;
	Location loc;
	
	public Movement(Entity e, Vector2 v, Location l) {
		super(e);
		this.endLoc = v;
		this.loc =l;
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean perform() {
		if(loc.getTile((int)endLoc.x/10, (int)endLoc.y/10, 0)!= 0
				&& loc.getTile((int)endLoc.x/10, (int)endLoc.y/10, 0)!= 5){//collision detect here
			this.performer.pos=endLoc;
		return true;
		}
		return false;
	}

}
