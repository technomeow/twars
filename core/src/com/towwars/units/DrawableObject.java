package com.towwars.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

/**
 * Created by vafin_mk on 11.04.15.
 */
public abstract class DrawableObject {

    protected static final Random RND = new Random();

    protected int xPosition, yPosition;
    protected int xTarget, yTarget;
    protected Texture texture;

    protected boolean moving;
    protected long lastUpdateTime = 0;

    public DrawableObject(Texture texture, int xPosition, int yPosition, int xTarget, int yTarget) {
        this.texture = texture;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xTarget = xTarget;
        this.yTarget = yTarget;
    }

    public DrawableObject(Texture texture, int xPosition, int yPosition) {
        this(texture, xPosition, yPosition, 0, 0);
    }

    public DrawableObject(Texture texture) {
        this(texture, 0, 0, 0, 0);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, xPosition , yPosition);
    }

    public abstract void update();

    protected void moveToTarget(int speed)
    {
//        System.out.println("BEFORE:x="+xPosition + "|y=" + yPosition + "(" + this + ")");
        if(xPosition == xTarget && yPosition == yTarget) {
            moving = false;
            return;
        }
        if(xPosition != xTarget) {
            if (xPosition > xTarget) {
                if(xPosition - speed < xTarget) {
                    xPosition = xTarget;
                } else {
                    xPosition -= speed;
                }
            } else {
                if(xPosition + speed > xTarget) {
                    xPosition = xTarget;
                } else {
                    xPosition += speed;
                }
            }
        }
        if(yPosition != yTarget) {
            int mY = RND.nextInt(10);
            if (yPosition > yTarget) {
                if(yPosition - mY < yTarget) {
                    yPosition = yTarget;
                } else {
                    yPosition -= mY;
                }
            } else {
                if(yPosition + mY > yTarget) {
                    yPosition = yTarget;
                } else {
                    yPosition += mY;
                }
            }
        }
//        System.out.println("ADTER:x="+xPosition + "|y=" + yPosition+ "(" + this + ")");
    }
}
