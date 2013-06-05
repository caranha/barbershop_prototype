package org.castelodelego.claus.barber;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "BarberPrototype";
		cfg.useGL20 = false;
		cfg.width = PrototypeMain.WIDTH;
		cfg.height = PrototypeMain.HEIGHT;
		
		new LwjglApplication(new PrototypeMain(), cfg);
	}
}
