package org.castelodelego.claus.barber;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

public class CutScreen implements Screen {

	LevelContext c;
	
	public void init()
	{
		c = new LevelContext();
	}
	
	@Override
	/**
	 * Render and Update cycle (at least for now)
	 */
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		c.blade.playerAccel(Gdx.input.isTouched());
		
		c.blade.update(c, delta);
		c.skin.update(c, delta);
		c.blood.update(delta);
		c.hair.update(c, delta);
		c.update(delta);
		
		c.blade.draw(c);
		c.skin.draw(c);
		c.hair.draw(c);
		c.blood.draw(c);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		c.blade.init();
		c.skin.init();
		c.blood.init();
		c.hair.init();
		c.init();

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
