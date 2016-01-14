/*
 * Daniel Ross
 */
package com.egs.gameworld;

import com.egs.gameobjects.Ball;

/**
 *
 * @author daros0591
 */
public class GameWorld {

    private Ball ball;
    /**
     * 
     */
     public GameWorld() {
        ball = new Ball();
    }
    
    public void update(float delta) {
        ball.update();
    }
    
    public Ball getBall(){
        return ball;
    }
    
}

