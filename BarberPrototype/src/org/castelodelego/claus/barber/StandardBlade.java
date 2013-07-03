package org.castelodelego.claus.barber;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

public class StandardBlade {

	/*
	 * TODO: Change blade movement from straight to curved
	 */
	
	public Vector2 position; // current position

	public Vector2 xspeed; // Current horizontal speed
	public Vector2 yspeed; // Current vertical speed
	
	public Vector2 movement; // change of position this update, for collision purposes

	public Vector2 gravity; // fixed horizontal acceleration
	public Vector2 playeracc; // player-based horizontal acceleration
	public boolean isPlayerAcc;
	
	float xmin;
	float xmax;
	
	ShapeRenderer linedrawer;
	
	public StandardBlade()
	{
		// Static parameters
		gravity = new Vector2(-5,0);
		playeracc = new Vector2(15,0);

		yspeed = new Vector2(0,150);
		linedrawer = new ShapeRenderer();
		
		xmin = 70;
		xmax = 450;
	}
	
	public void init()
	{
		xspeed = new Vector2(0,0);
		movement = new Vector2(0,0);		
		
		position = new Vector2(150,100);
		
		isPlayerAcc = false;
		
	}
	
	public void update(LevelContext c, float delta)
	{
		// update x speed
		Vector2 acc = new Vector2(gravity);
		if (isPlayerAcc)
			acc.add(playeracc);
		acc.mul(delta);
		xspeed.add(acc);
		
		// calculate movement
		Vector2 ydelta = new Vector2(yspeed);
		ydelta.mul(delta);

		(movement.set(xspeed)).add(ydelta);;
		
		// clamp movement on the x axis
		if ((movement.x + position.x) < xmin)
		{
			movement.x = xmin - position.x;
			xspeed.x = 0;
		}
		if ((movement.x + position.x > xmax))
		{
			movement.x = xmax - position.x;
			xspeed.x = 0;
		}
		
		// update position and camera		
		position.add(movement);
		c.camera.translate(0,movement.y);
		
	}
	
	/**
	 */
	public void draw(LevelContext c)
	{
		
		
		// Drawing Guide point
		linedrawer.setProjectionMatrix(c.camera.combined);
		
		//giving errors, so changed from Circle to Filledfor now
		linedrawer.begin(ShapeType.Filled);
		
		linedrawer.setColor(Color.BLACK);
		linedrawer.circle(position.x, position.y, 2);
		linedrawer.end();
				
		// Drawing blade
	}

	public void playerAccel(boolean touched) {
		isPlayerAcc = touched;
	}
	
	
}
