package org.castelodelego.claus.barber;

import com.badlogic.gdx.Game;

public class PrototypeMain extends Game {

	static final int HEIGHT = 800;
	static final int WIDTH = 480;
	
	CutScreen gamescreen;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		gamescreen = new CutScreen();
		gamescreen.init();
		setScreen(gamescreen);		
	}


}
