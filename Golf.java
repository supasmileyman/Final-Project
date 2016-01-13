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
        //Display introscreen
        
            //Display menu option
            int choice = Integer.parseInt(JOptionPane.showInputDialog("Hello! Would you like to: \n"
                    + "1. Play Game \n"
                    + "2. See Highscores \n"
                    + "3. Credits"));
            //Run their selection
            if(choice == 1){
                setScreen(new GameScreen());
            }else if(choice == 2){
                //Display highscore screen
            }else if(choice == 3){
                //Display credits
            }
    }
    
     @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
