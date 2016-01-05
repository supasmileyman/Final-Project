package com.egs.eddiegolfsim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.egs.screens.GameScreen;

public class Golf extends Game {
    
    //Created game
    @Override
    public void create() {
        Gdx.app.log("Eddie's Golf Simulator", "created");
        setScreen(new GameScreen());
    }
	
}
