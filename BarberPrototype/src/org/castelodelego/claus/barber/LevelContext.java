package org.castelodelego.claus.barber;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class LevelContext {

	OrthographicCamera camera;
	StandardBlade blade;
	LevelContext c;
	SkinManager skin;
	BloodManager blood;
	HairManager hair;
	
	public LevelContext()
	{
		camera = new OrthographicCamera();		
		blade = new StandardBlade();
		skin = new SkinManager();
		blood = new BloodManager();
		hair = new HairManager();
	}

	public void init()
	{
		camera.setToOrtho(false, 480, 800);
	}

	public void update(float delta) {
		camera.update();
	}
	
}
