package org.castelodelego.claus.barber;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class BloodManager {
	
	
	ShapeRenderer linedrawer;
	Array<BloodSpot> blist;
	
	public BloodManager()
	{
		linedrawer = new ShapeRenderer();
		blist = new Array<BloodSpot>(false,50);
	}
	
	public void init()
	{
		blist.clear();
	}
	
	public void addBlood(Vector2 p)
	{
		blist.add(new BloodSpot(p));
	}

	public void update(float delta)
	{
		int i = 0;
		while (i < blist.size)
		{
			if (blist.get(i).update(delta))
				blist.removeIndex(i);
			else
				i++;
		}
	}
	
	public void draw(LevelContext c)
	{
		linedrawer.setProjectionMatrix(c.camera.combined);
		
		//giving errors, so commenting out for now
		//linedrawer.begin(ShapeType.FilledCircle);
		linedrawer.begin(ShapeType.Filled);
		
		for (int i = 1; i < blist.size; i++)
		{
			BloodSpot t = blist.get(i);
			linedrawer.setColor(1, 0, 0, (t.maxage - t.age/2)/t.maxage);
			
			//giving errors, so commenting out for now
			//linedrawer.filledCircle(t.pos.x, t.pos.y, t.age*30);
			linedrawer.circle(t.pos.x, t.pos.y, t.age*30);
		}
		linedrawer.end();		
	}

}
