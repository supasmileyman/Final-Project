/*
 * Daniel Ross
 */
package com.egs.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.egs.golfhelpers.AssetLoader;

/**
 *
 * @author Daniel
 */
public class Ball {

    boolean right, down, go;

    private Circle hitbox;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int lvl;
    private int score;
    private int width;
    private int height;

    /**
     * Constructor of ball object
     */
    public Ball() {
        height = 16;
        width = 16;
        position = new Vector2(40, 252);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
        score = 0;
        lvl = 0;
        hitbox = new Circle();

    }

    /**
     * Update method to update position and velocities Includes hard coded hit
     * boxes as well as hard coded level increasing
     */
    public void update() {
        //If go is true then go to the nested ifs
        if (go == true) {
            //If right is true and the speed is higher than 0.02 accelerate the ball on the x
            if (right == true && velocity.x > 0.025) {
                acceleration.x = (float) -0.025;
            } else if (right == false && velocity.x > 0.025) {
                acceleration.x = (float) -0.025;
            } else {
                //else round it off and stop its acceleration
                Math.floor(velocity.x);
                acceleration.x = 0;
            }

            //If down is true and hte speed is higher than 0.02 accelerate the ball on the y
            if (down == true && velocity.y > 0.015) {
                acceleration.y = (float) -0.015;
            } else if (down == false && velocity.y > 0.015) {
                acceleration.y = (float) -0.015;
            } else {
                Math.floor(velocity.y);
                acceleration.y = 0;
            }
        } else {
            go = false;
        }

        //Change the velocity 
        velocity.add(acceleration.cpy());

        //Cap the speed of the ball
        if (velocity.y > 5) {
            velocity.y = 5;
        } else if (velocity.y < -5) {
            velocity.y = -5;
        }
        if (velocity.x > 5) {
            velocity.x = 5;
        } else if (velocity.x < -5) {
            velocity.x = -5;
        }
        //Add to the positionx
        if (right == true) {
            position.x += velocity.x;
        } else {
            position.x -= velocity.x;
        }

        //Add to the positiony
        if (down == true) {
            position.y += velocity.y;
        } else {
            position.y -= velocity.y;
        }

        // Level hitboxes
        if (lvl == 0) {
            position.x = 2000;
            position.y = 2000;
            velocity.x = 0;
            velocity.y = 0;
            acceleration.x = 0;
            acceleration.y = 0;
            //Load for level 1
            if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
                position.x = 40;
                position.y = 252;
                lvl = 1;
            }
            //Load for high Score
            if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
                lvl = 20;
                
            }
            //Load for credits
             if (Gdx.input.isKeyPressed(Keys.NUM_3)) {
                lvl = 21;
            }
        } else if (lvl == 1) {
            level1Hit();
        } else if (lvl == 2) {
            level2Hit();
        } else if (lvl == 3) {
            level3Hit();
        }else{
            
        }
    }

    /**
     * onClick it will do something
     */
    public void onClick() {
        double vX;
        double vY;
        score++;
        go = true;

        //Play the swing sound'
        if (lvl >= 1) {
            AssetLoader.swing.play(100);
        }
        //Calculate the velocity of the ball
        vX = (Gdx.input.getX() - position.x) * 0.040;
        vY = (Gdx.input.getY() - position.y) * 0.030;

        //if the mouse is to the right of the ball send it right else send it left
        if (position.x < Gdx.input.getX()) {
            right = true;
        } else {
            right = false;
            vX = vX * -1;
        }

        //If the mouse is below the ball send it down else send it up
        if (position.y < Gdx.input.getY()) {
            down = true;
        } else {
            down = false;
            vY = vY * -1;
        }
        //Set the velocities 
        velocity.x = (float) vX;
        velocity.y = (float) vY;

    }

    /**
     * gets the current position of the ball object
     *
     * @return the x position
     */
    public float getX() {
        return position.x;
    }

    /**
     * gets the current position of the ball
     *
     * @return y position
     */
    public float getY() {
        return position.y;
    }

    /**
     * gets the velocity of the x
     *
     * @return x velocity
     */
    public float getVelocityX() {
        return velocity.x;
    }

    /**
     * gets the velocity in the y direction
     *
     * @return y velocity
     */
    public float getVelocityY() {
        return velocity.y;
    }

    /**
     * gets the current score
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets the current lvl
     *
     * @return the lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * Sets the x position
     *
     * @param newX
     */
    public void setX(int newX) {
        position.x = newX;
    }

    /**
     * Sets the y position
     *
     * @param newY
     */
    public void setY(int newY) {
        position.y = newY;
    }

    /**
     * sets the x velocity
     *
     * @param newX
     */
    public void setVelocityX(int newX) {
        velocity.x = newX;
    }

    /**
     * sets the y velocity
     *
     * @param newY
     */
    public void setVelocityY(int newY) {
        velocity.y = newY;
    }

    /**
     * sets the score
     *
     * @param s
     */
    public void setScore(int s) {
        score = s;
    }

    /**
     * Set the level
     *
     * @param l level to set to
     */
    public void setLvl(int l) {
        lvl = l;
    }

    /**
     * The hit boxes for level1
     */
    public void level1Hit() {
        // Left Wall
        if (position.x < 32) {
            right = true;
        }

        // Top Wall
        if (position.y < 32) {
            down = true;
        }

        // Bottom Wall
        if (position.y > 448) {
            down = false;
        }

        // Right Wall
        if (position.x > 956) {
            right = false;
        }

        // Hole
        if (position.x > 956 && position.y > 204 && position.y < 236) {
            AssetLoader.hole.play();
            //JOptionPane.showMessageDialog(null,"Congrats");
            position.x = 150;
            position.y = 400;
            velocity.x = 0;
            velocity.y = 0;
            acceleration.x = 0;
            acceleration.y = 0;
            lvl = 2;
        }
    }

    /**
     * The hit boxes for level2
     */
    public void level2Hit() {
        // Left Wall
        if (position.x < 32) {
            right = true;
        }

        // Top Wall
        if (position.y < 32) {
            down = true;
        }

        // Bottom wall under ball spawn
        if (position.y > 448 && position.x > 32 && position.x < 320) {
            down = false;
        }

        //Wall Under Hole
        if (position.y > 224 && position.x > 320) {
            down = false;
        } else // Wall right of ball spawn
        if (position.y < 448 && position.y > 224 && position.x > 288) {
            right = false;
        }
        // Wall right of hole
        if (position.x > 960) {
            right = false;
        }

        // Hole
        if (position.x > 956 && position.y > 104 && position.y < 136) {
            AssetLoader.hole.play(100);
            //JOptionPane.showMessageDialog(null,"Congrats");
            position.x = 150;
            position.y = 400;
            velocity.x = 0;
            velocity.y = 0;
            acceleration.x = 0;
            acceleration.y = 0;
            lvl = 3;
        }

    }

    /**
     * The hitboxes for level3
     */
    public void level3Hit() {
        //Fill in here
    }
}
