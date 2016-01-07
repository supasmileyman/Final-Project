/*
 * Daniel Ross
 */
package com.egs.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Daniel
 */
public class Ball {

    public static TextureRegion ball;
    private Circle hitbox;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;
    
    /**
     * Constructor of ball object
     */
    public Ball(){
        height = 16;
        width = 16;
        position = new Vector2(0,0);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,0);
        hitbox = new Circle();
        
    }
    /**
     * Update method to update position and velocities
     */
    public void update(){
        velocity.sub(acceleration.cpy());
        if(velocity.y > 150){
            velocity.y = 150;
        }
        if(velocity.x > 150){
            velocity.x = 150;
        }
        position.add(velocity.cpy());
        
        //Could cause error might have to make position x and position y methods
        hitbox.setPosition(position);
    }
    /**
     * onClick it will do something
     */
    public void onClick(){
        velocity = new Vector2(0,0);
    }
    /**
     * gets the current position of the ball object
     * @return the x position 
     */
    
    public float getX(){
        return position.x;
    }
    /**
     * gets the current position of the ball
     * @return y position
     */
    public float getY(){
        return position.y;
    }
    /**
     * gets the velocity of the ball
     * @return x and y components of the velocity
     */
    public Vector2 getVelocity(){
        return velocity;
    }
    /**
     * gets the acceleration of the ball
     * @return the acceleration 
     */
    public Vector2 getAccel(){
        return acceleration;
    }
    
    public Circle getHitbox(){
        return hitbox;
    }
    /**
     * sets the position of the ball
     * @param x x position
     * @param y  y position 
     */
    public void setPosition(int x, int y){
        position = new Vector2(x,y);
    }
    /**
     * sets the velocity of the ball
     * @param x x position 
     * @param y y position
     */
    public void setVelocity(int x, int y){
        velocity = new Vector2(x,y);
    }
    /**
     * sets the acceleration of the ball
     * @param x x position 
     * @param y y position
     */
    public void setAccel(int x, int y){
        acceleration = new Vector2(x,y);
    }
    
    
}
