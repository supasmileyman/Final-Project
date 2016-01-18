package com.egs.eddiegolfsim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.egs.screens.*;
import com.egs.golfhelpers.*;
import javax.swing.JOptionPane;

public class Golf extends Game {

    //Created game
    @Override
    public void create() {
        Gdx.app.log("Eddie's Golf Simulator", "created");
        AssetLoader.load();
        int rand = (int)(Math.random()*2)+1;
        if(rand == 1){
        AssetLoader.theme1.play((float)0.4);
        }else{
        AssetLoader.theme2.play((float)0.4);
        }
        //Display introscreen
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
