package org.castelodelego.claus.barber;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class PrototypeMain extends Game {

	static final int HEIGHT = 800;
	static final int WIDTH = 480;
	
	static AssetManager manager;
	
	public CutScreen gamescreen;
	public TitleScreen entryscreen;
	
	

	@Override
	public void create() {

		// TODO: Create a separate function for loading and managing assets
		manager = new AssetManager();
		manager.load("joystix24.fnt", BitmapFont.class);
		
		// TODO: Add this to an asset loading screen
		while (!(manager.update()))
		{
			
		}
		
		
		gamescreen = new CutScreen(this);
		entryscreen = new TitleScreen(this);
		
		gamescreen.init();
		setScreen(entryscreen);		
	}


}
