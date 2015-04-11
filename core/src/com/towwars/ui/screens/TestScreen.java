package com.towwars.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.towwars.TWarsGame;
import com.towwars.units.Shooter;

import java.util.ArrayList;
import java.util.List;

public class TestScreen implements Screen {

    private List<Shooter> shooters;
    private final TWarsGame game;

    public TestScreen(final TWarsGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        shooters = new ArrayList<Shooter>();
        shooters.add(new Shooter(new Texture("shooter1.png"), 100, 100));
        shooters.add(new Shooter(new Texture("shooter2.png"), 300, 300));
        shooters.add(new Shooter(new Texture("shooter3.png"), 500, 500));
        shooters.add(new Shooter(new Texture("shooter4.png"), 700, 700));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1); //sets clear color to black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clear the batch
        shooters.forEach(s -> s.update());
        game.batch.begin();
        shooters.forEach(s -> s.draw(game.batch));
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
    }
}
