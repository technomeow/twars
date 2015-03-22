package com.towwars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TWarsGame extends ApplicationAdapter {
	SpriteBatch batch;
    Texture tower;
    Texture bullet;
    Texture mob;

	@Override
	public void create () {
		batch = new SpriteBatch();
		tower = new Texture("t1.png");
        bullet = new Texture("b1.png");
        mob = new Texture("m1.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(tower, 0, 0);
        batch.draw(mob, 100, 100);
		batch.end();
	}
}
