package org.castelodelego.claus.barber;

import com.badlogic.gdx.math.Vector2;

public class BloodSpot {

	Vector2 pos;
	float age;
	float maxage = 0.5f;
	
	public BloodSpot(Vector2 p)
	{
		pos = new Vector2(p);
		age = 0;
	}
	
	public boolean update(float delta)
	{
		age += delta;
		return (age > maxage);
	}
}
