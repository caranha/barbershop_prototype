package org.castelodelego.claus.barber;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


/**
 * Skin Manager generates the vectors that create the skin
 * @author caranha
 *
 */
public class SkinManager {
	
	float xmax;
	float xmin;
	float ylen;
	
	Array<Vector2> skinlist;
	
	ShapeRenderer linedrawer;
	Random dice;
	
	boolean playeraccel;
	
	public SkinManager()
	{
		dice = new Random();
		linedrawer = new ShapeRenderer();
		skinlist = new Array<Vector2>();
	}

	public void init()
	{
		xmax = 100;
		xmin = 80;
		ylen = 50;
		
		// Generate the first few vectors;
		skinlist.clear();
		for (int i = 0; i < (PrototypeMain.HEIGHT/ylen)+3; i++)
			skinlist.add(new Vector2(dice.nextFloat()*(xmax-xmin)+xmin,ylen*i));		
	}
	
	public void update(LevelContext c, float delta)
	{
		// Test if we need to remove the bottom vector (and add a new one)
		if (skinlist.get(1).y < c.camera.position.y - (PrototypeMain.HEIGHT/2))
		{
			skinlist.removeIndex(0);
			float lasty = skinlist.get(skinlist.size-1).y;
			skinlist.add(new Vector2(dice.nextFloat()*(xmax-xmin)+xmin,ylen+lasty));
		}
		
		// Test Collision with the blade
		int i = 0;
		while (c.blade.position.y > skinlist.get(i).y)
			i++;
		if (Intersector.pointLineSide(skinlist.get(i-1), skinlist.get(i), c.blade.position)==1)
		{
			c.blood.addBlood(c.blade.position);
		}
	}
	
	public void draw(LevelContext c)
	{
		linedrawer.setProjectionMatrix(c.camera.combined);
		linedrawer.begin(ShapeType.Line);
		linedrawer.setColor(Color.BLACK);

		Vector2 p0 = skinlist.get(0);
		Vector2 p1;
		
		for (int i = 1; i < skinlist.size; i++)
		{
			p1 = skinlist.get(i);
			linedrawer.line(p0.x, p0.y, p1.x, p1.y);
			p0 = p1;
		}

		linedrawer.end();
	}

	
}
