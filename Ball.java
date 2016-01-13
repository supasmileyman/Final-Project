/*
 * Daniel Ross
 */
package com.egs.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

    private int score;
    private int width;
    private int height;
    
    /**
     * Constructor of ball object
     */
    public Ball(){
        height = 16;
        width = 16;
        position = new Vector2(40,252);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,0);
        score = 0;
        hitbox = new Circle();
        
    }
    /**
     * Update method to update position and velocities
     */
    public void update(){
        //If go is true then go to the nested ifs
        if(go == true){
            //If right is true and the speed is higher than 0.02 accelerate the ball on the x
            if(right == true && velocity.x > 0.02){
                acceleration.x = (float)-0.02;
            }else if(right == false && velocity.x > 0.02){
                acceleration.x = (float) -0.02;
            }else{
                //else round it off and stop its acceleration
                Math.floor(velocity.x);
                acceleration.x = 0;
            }
            //If down is true and hte speed is higher than 0.02 accelerate the ball on the y
            if(down == true && velocity.y > 0.02){
                acceleration.y = (float)-0.02;
            }else if(down == false && velocity.y > 0.02){
                acceleration.y = (float) -0.02;
            }else{
                Math.floor(velocity.y);
                acceleration.y = 0;
            }
        }else{
            go = false;
        }
    
        //Change the velocity 
        velocity.add(acceleration.cpy());
        
        //Cap the speed of the ball
        if(velocity.y > 4){
            velocity.y = 4;
        }else if(velocity.y < -4){
            velocity.y = -4;
        }
        if(velocity.x > 4){
            velocity.x = 4;
        }else if(velocity.x < -4){
            velocity.x = -4;
        }
        //Add to the position
        if(right == true){
            position.x += velocity.x;
        }else{
            position.x -=velocity.x;
        }
        
        if(down == true){
            position.y += velocity.y;
        }else{
            position.y -= velocity.y;
        }
        
        //Could cause error might have to make position x and position y methods
        hitbox.setPosition(position);
        System.out.println(velocity);
    }
    /**
     * onClick it will do something
     */
    public void onClick(){        
        double vX;
        double vY;
        score++;
        go = true;
        //Play the swing sound'
        AssetLoader.swing.play();
        //Calculate the velocity of the ball
         vX = (Gdx.input.getX() - position.x)* 0.045;
         vY = (Gdx.input.getY() - position.y) *0.025;
        
         //if the mouse is to the right of the ball send it right else send it left
         if(position.x < Gdx.input.getX()){
            right = true;
        }else{
            right = false;
            vX = vX*-1;
        }
        
        //If the mouse is below the ball send it down else send it up
        if(position.y < Gdx.input.getY()){
            down = true;
        }else{
            down = false;
            vY = vY*-1;
        }
        //Set the velocities 
        velocity.x = (float)vX;
        velocity.y = (float)vY;
       
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
     * gets the velocity of the x
     * @return x velocity 
     */
    public float getVelocityX(){
        return velocity.x;
    }
    /**
     * gets the velocity in the y direction
     * @return y velocity
     */
    public float getVelocityY(){
        return velocity.y;
    }
    /**
     * gets the current score 
     * @return the score
     */
    public int getScore(){
        return score;
    }
    
    /**
     * Sets the x position
     * @param newX 
     */
    public void setX(int newX){
        position.x = newX;
    }
    /**
     * Sets the y position
     * @param newY 
     */
    public void setY(int newY){
        position.y = newY;
    }
    /**
     * sets the x velocity
     * @param newX 
     */
    public void setVelocityX(int newX){
        velocity.x = newX;
    }
    /**
     * sets the y velocity
     * @param newY 
     */
    public void setVelocityY(int newY){
        velocity.y = newY;
    }
    /**
     * sets the score
     * @param s 
     */
    public void setScore(int s){
        score = s;
    }
}
    
