package org.castelodelego.claus.barber;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleScreen implements Screen {

	BitmapFont scoreFont;
	SpriteBatch batch;
	PrototypeMain parent;
	
	public TitleScreen(PrototypeMain p)
	{
		parent = p;
		scoreFont = PrototypeMain.manager.get("joystix24.fnt", BitmapFont.class);
		batch = new SpriteBatch();
	}
	
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		scoreFont.setColor(Color.GRAY);
		scoreFont.draw(batch, "Press Space to ROCK!", 40, 400);
		if (parent.gamescreen.initialized)
		{
			scoreFont.draw(batch, "Best Score: "+ (int) Math.floor((double)parent.gamescreen.c.maxscore), 90, 360);
			scoreFont.draw(batch, "Last Score: "+ (int) Math.floor((double)parent.gamescreen.c.score), 90, 330);
		}
		batch.end();

		
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
			parent.setScreen(parent.gamescreen);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
