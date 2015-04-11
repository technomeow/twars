package com.towwars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.towwars.units.DrawableObject;

/**
 * Created by vafin_mk on 11.04.15.
 */
public class Bullet extends DrawableObject{

    private boolean dead;
    public Bullet() {
        super(new Texture("bullet1.png"));
    }

    public Bullet(int xPos, int yPos) {
        super(new Texture("bullet1.png"), xPos, yPos);
    }

    public Bullet(int xPos, int yPos, int xTarget, int yTarget) {
        super(new Texture("bullet1.png"), xPos, yPos, xTarget, yTarget);
    }

    @Override
    public void update() {
        if(dead) {
            return;
        }
        if(xPosition == xTarget && yPosition == yTarget) {
            die();
            return;
        }
        moveToTarget(RND.nextInt(15));
    }

    @Override
    public void draw(SpriteBatch batch) {
        if(dead) {
            return;
        }
        batch.draw(texture, xPosition, yPosition, 10, 10);
    }
    
    private void die() {
        dead = true;
        texture.dispose();
    }

    public boolean isDead() {
        return dead;
    }
}
