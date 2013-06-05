package org.castelodelego.claus.barber;

import com.badlogic.gdx.math.Vector2;

public class StandardHair {

	Vector2 position;
	Vector2 endpos;
	Vector2 targetpos;
	
	float length;
	float targetlength;
	
	float baseangle;
	
	
	boolean isCut;
	
	public StandardHair(Vector2 p, float l, float tl)
	{
		position = new Vector2(p);
		endpos = new Vector2();
		targetpos = new Vector2();
		
		length = l;
		targetlength = tl;
		baseangle = -10;
		isCut = false;
		
		
		endpos.set(1,0);
		endpos.setAngle(baseangle);
		targetpos.set(endpos);

		endpos.mul(length);
		endpos.add(position);
		
		targetpos.mul(targetlength);
		targetpos.add(position);
	}
	
	public void update(float angle)
	{
//		endpos.set(1,0);
//		endpos.setAngle(baseangle);
//		//endpos.rotate(angle);
//		targetpos.set(endpos);
//		
//		endpos.mul(length);
//		targetpos.mul(targetlength);
	}
	
	public void cut(Vector2 pos)
	{
		if (pos == null)
			return;
		//TODO: Should not enter here, log a warning;
		endpos.set(pos);
//		length = position.dst(pos);
		isCut = true;
	}
	
	
}
