package com.towwars.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.towwars.TWarsGame;

public class TestScreen implements Screen {

    private Texture tower;
    private Texture mob;
    private final TWarsGame game;
    private Stage stage;

    public TestScreen(final TWarsGame game) {
        this.game = game;
        tower = new Texture("t1.png");
        mob = new Texture("m1.png");
        stage = new Stage();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1); //sets clear color to black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clear the batch
//        stage.act(); //update all actors
//        stage.draw(); //draw all actors on the Stage.getBatch()
        game.batch.begin();
        game.batch.draw(tower, 0, 0);
        game.batch.draw(mob, 250, 400);
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
        tower.dispose();
        mob.dispose();
        stage.dispose();
    }
}
