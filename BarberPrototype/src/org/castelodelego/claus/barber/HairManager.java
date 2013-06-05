package org.castelodelego.claus.barber;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class HairManager {

	float lenmin;
	float lendelta;
	float angledelta;
	float yspace;
	
	Array<StandardHair> hlist;
	
	ShapeRenderer linedrawer;
	Random dice;
	
	public HairManager()
	{
		dice = new Random();
		linedrawer = new ShapeRenderer();
		hlist = new Array<StandardHair>();
	}

	public void init()
	{
		lenmin = 350;
		lendelta = 50;
		angledelta = 5;
		yspace = 15;
		
		// Generate the first few vectors;
		hlist.clear();
		int county = 70;
		
		while (county < PrototypeMain.HEIGHT+200)
		{
			county += yspace+dice.nextInt(5); 			
			Vector2 pos = new Vector2(50+dice.nextInt(10),county);
			hlist.add(new StandardHair(pos,lenmin+dice.nextFloat()*lendelta,((dice.nextFloat()*0.2f)+0.4f)*lenmin));
		}
	}
	
	public void update(LevelContext c, float delta)
	{
		// Test if we need to remove the bottom vector (and add a new one)
		while (hlist.get(0).position.y < c.camera.position.y - (PrototypeMain.HEIGHT/2))
		{
			hlist.removeIndex(0);
			float lasty = hlist.get(hlist.size-1).position.y;
			hlist.add(new StandardHair(new Vector2(50+dice.nextInt(10),lasty+yspace+dice.nextInt(5)),
													lenmin+dice.nextFloat()*lendelta,
													((dice.nextFloat()*0.2f)+0.4f)*lenmin));
		}
		
		// Test Collision with the blade
		
		Vector2 cutpos = new Vector2();
		Vector2 cutdir = new Vector2(c.blade.position);
		cutdir.sub(c.blade.movement);
		
		for(int i = 0; i < hlist.size;i++)
		{
			StandardHair th = hlist.get(i);
			
			//th.update((dice.nextFloat()-0.5f)*angledelta);
						
			if (Intersector.intersectSegments(th.position, th.endpos, c.blade.position, cutdir, cutpos))
				th.cut(cutpos);
		}
	}
	
	public void draw(LevelContext c)
	{
		linedrawer.setProjectionMatrix(c.camera.combined);
		
		linedrawer.begin(ShapeType.Line);
		linedrawer.setColor(Color.BLACK);
		for (int i = 0; i < hlist.size; i++)
		{
			StandardHair th = hlist.get(i);
			linedrawer.line(th.position.x, th.position.y, th.endpos.x, th.endpos.y);
		}
		linedrawer.end();
		
		linedrawer.begin(ShapeType.Circle);
		linedrawer.setColor(Color.RED);
		for (int i = 0; i < hlist.size; i++)
			{
				StandardHair th = hlist.get(i);
				if (th.isCut == false)
					linedrawer.circle(th.targetpos.x, th.targetpos.y, 3);
			}
		linedrawer.end();
	}
}
