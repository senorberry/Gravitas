/*
 * Kyle Berry 2016
 */

package com.berry.gravitas;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.math.Vector2;



public class Movement extends Action {

	public static final Integer[] SET_VALUES = new Integer[] { 1,2 };
	public static final Set<Integer> MY_SET = new HashSet<Integer>(Arrays.asList(SET_VALUES));

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
		//can action be performed
		//environment collision detection
		if(loc.getTile((int)endLoc.x/10, (int)endLoc.y/10, 0)> 0
				&& loc.getTile((int)endLoc.x/10, (int)endLoc.y/10, 0)!= 5)
		{
			this.performer.pos=endLoc;
		return true;
		}
		return false;
	}

}
