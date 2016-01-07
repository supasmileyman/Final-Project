package com.egs.eddiegolfsim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.egs.screens.GameScreen;
import com.egs.golfhelpers.*;

public class Golf extends Game {
    
    //Created game
    @Override
    public void create() {
        Gdx.app.log("Eddie's Golf Simulator", "created");
        AssetLoader.load();
        setScreen(new GameScreen());
    }
	
     @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
