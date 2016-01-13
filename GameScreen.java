/*
 *Daniel Ross
 */
package com.egs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;
import com.egs.gameworld.*;
import com.egs.golfhelpers.InputHandler;

/**
 *
 * @author daros0591
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    /**
     * creates the game screen object, which is the screen itself
     */
    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();      
        float gameWidth = 1024;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);
        //Intialize a new gameworld and renderer screeen
        world = new GameWorld();
        renderer = new GameRenderer(world,512 ,midPointY);
        
        Gdx.input.setInputProcessor(new InputHandler(world.getBall()));
    }
/**
 * renders the screen
 * @param delta frame rate
 */
    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }
    //Most methods unused but required
/**
 * resizes the screen
 * @param width
 * @param height 
 */
    @Override
    public void resize(int width, int height) {
        //Unused 
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
