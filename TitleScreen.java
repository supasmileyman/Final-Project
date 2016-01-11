/**
 * Daniel Ross
 */

package com.egs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.egs.gameworld.GameRenderer;
import com.egs.gameworld.GameWorld;
import com.egs.zbhelpers.InputHandler;

/**
 *
 * @author daros0591
 */
public class TitleScreen implements Screen {
    
        private GameWorld world;
        private GameRenderer renderer;
    
        public TitleScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();      
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        
        int midPointY = (int) (gameHeight / 2);

        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world);
        
        Gdx.input.setInputProcessor(new InputHandler(world.getBall()));
    }
        @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        Gdx.app.log("TitleScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("TitleScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("TitleScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("TitleScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
