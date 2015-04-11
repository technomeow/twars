package com.towwars.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.towwars.Bullet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vafin_mk on 11.04.15.
 */
public class Shooter extends DrawableObject{

    private static final Random RND = new Random();
    private List<Bullet> bullets = new ArrayList<>();

    private long lastUpdateTime = 0;

    public Shooter(Texture texture) {
        super(texture);
    }

    public Shooter(Texture texture, int xPos, int yPos) {
        super(texture, xPos, yPos);
    }

    @Override
    public void draw(SpriteBatch batch) {
        if(!bullets.isEmpty()) {
            bullets.forEach(x -> x.draw(batch));
        }
        super.draw(batch);
    }

    @Override
    public void update() {
        if(!moving) {
            randomMoveTarget();
        }
        moveToTarget(RND.nextInt(10));
        if(!bullets.isEmpty()) {
            bullets.removeIf(x -> x.isDead());
            bullets.forEach(x -> x.update());
        }
        if(System.currentTimeMillis() - lastUpdateTime < 1_000) {
            return;
        }
        lastUpdateTime = System.currentTimeMillis();
        shoot();
    }

    private void randomMoveTarget()
    {
        xTarget = RND.nextInt(Gdx.graphics.getHeight());
        yTarget = RND.nextInt(Gdx.graphics.getWidth());
        moving = true;
    }

    private void shoot() {
        bullets.add(new Bullet(xPosition, yPosition, RND.nextInt(Gdx.graphics.getHeight()), RND.nextInt(Gdx.graphics.getWidth())));
        bullets.add(new Bullet(xPosition, yPosition, RND.nextInt(Gdx.graphics.getHeight()), RND.nextInt(Gdx.graphics.getWidth())));
        bullets.add(new Bullet(xPosition, yPosition, RND.nextInt(Gdx.graphics.getHeight()), RND.nextInt(Gdx.graphics.getWidth())));
        bullets.add(new Bullet(xPosition, yPosition, RND.nextInt(Gdx.graphics.getHeight()), RND.nextInt(Gdx.graphics.getWidth())));
        bullets.add(new Bullet(xPosition, yPosition, RND.nextInt(Gdx.graphics.getHeight()), RND.nextInt(Gdx.graphics.getWidth())));
    }

}
