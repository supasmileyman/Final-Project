/**
 * Eddie Simon
 */
package com.egs.golfhelpers;

import com.badlogic.gdx.InputProcessor;
import com.egs.gameobjects.Ball;

public class InputHandler implements InputProcessor{
    
    private Ball myBall;
    
    public InputHandler(Ball ball){
        myBall = ball;
    }
    //Only one is needed. 
    /**
     * when the mouse is pressed launch the ball
     * @param screenX 
     * @param screenY
     * @param pointer
     * @param button
     * @return true 
     */
     @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        myBall.onClick();
        return true;
    }
    //All other methods are unneeded but must be overrided  
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    
}
