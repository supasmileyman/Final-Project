/*
 * Daniel Ross
 */
package com.egs.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Daniel
 */ 
public class Ball {
    boolean right, down;
    
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
      //  System.out.println(position);
        boolean go = false;
        
        if(velocity.x > 0 && right == true){
            go = true;
            acceleration.x = (float)-.02;
        }else if(velocity.x < 0 && right == false){
            go = true;
            acceleration.x = (float).02;
        }else{
            acceleration.x = 0;
        }
        if(velocity.y > 0 && down == true){
            go = true;
            acceleration.y = (float)-.02;
        }else if(velocity.y < 0 && down == false){
            go = true;
            acceleration.y = (float).02;
        }else{
            acceleration.y = 0;
        }
    
        //Change the velocity 
        if(go == true){
        velocity.add(acceleration.cpy());
        }
        //Cap the speed of the ball
        if(velocity.y > 5){
            velocity.y = 5;
        }else if(velocity.y < -5){
            velocity.y = -5;
        }
        if(velocity.x > 5){
            velocity.x = 5;
        }else if(velocity.x < -5){
            velocity.x = -5;
        }
        //Add to the position
        if(right = true){
            position.add(velocity.cpy());
        }else{
            position.sub(velocity.cpy());
        }
        
        //Could cause error might have to make position x and position y methods
        hitbox.setPosition(position);
    }
    /**
     * onClick it will do something
     */
    public void onClick(){        
        double vX;
        double vY;
        System.out.println("Pos: " + position);
        System.out.println("Mouse X" + Gdx.input.getX());
         System.out.println("Mouse Y" + Gdx.input.getY());
        //if the mouse is to the right of the ball send it right else send it left
        if(position.x < Gdx.input.getX()){
            right = true;
             vX = (Gdx.input.getX()*.01) - position.x;
             System.out.println("fdsfds");
        }else{
            right = false;
            vX = (Gdx.input.getX()*.01) -  position.x;
            System.out.println("Hi");
        }
        
        //If the ball is below the mouse send it down else send it up
        if(position.y < Gdx.input.getY()){
            down = true;
            vY = (Gdx.input.getY()*.02) - position.y;
        }else{
            down = false;
            vY = (position.y) - Gdx.input.getY()*.02;
        }
        //Set the velocities 
        velocity.x = (float)vX;
        velocity.y = (float)vY;
        System.out.println("Velocity" + velocity);
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
}
