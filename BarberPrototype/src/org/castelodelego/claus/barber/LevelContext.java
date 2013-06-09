package org.castelodelego.claus.barber;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * This contains information about the level being played, including parameters, score, 
 * and the managers for all the level's objects.
 * 
 * @author caranha
 */

public class LevelContext {

	OrthographicCamera camera;
	StandardBlade blade;
	LevelContext c;
	SkinManager skin;
	BloodManager blood;
	HairManager hair;
	
	double curtime;
	double maxtime = 30;
	
	float score;
	float maxscore;
	
	public LevelContext()
	{
		camera = new OrthographicCamera();		
		blade = new StandardBlade();
		skin = new SkinManager();
		blood = new BloodManager();
		hair = new HairManager();
		maxscore = 0;
	}

	public void init()
	{
		camera.setToOrtho(false, 480, 800);
		curtime = 0;
		score = 0;
	}

	public void update(float delta) {
		camera.update();
		curtime += delta;
	}
	
	/**
	 * Returns true if the current time is above the time limit;
	 * @return
	 */
	public boolean isTimeOver()
	{
		return (curtime > maxtime);
	}
	
	public void addScore(double sd)
	{
		score += sd;
		if (score < 0)
			score = 0;
		if (score > maxscore)
			maxscore = score;
		
	}
	
}
