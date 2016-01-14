/**
 * Daniel Ross
 */

package com.egs.golfhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/**
 *
 * @author daros0591
 */
public class AssetLoader {
    public static Texture lvl1, lvl2, lvl3, ball, credit, ts;
    
    public static TextureRegion backGround1;
    public static TextureRegion backGround2;
    public static TextureRegion backGround3;
    public static TextureRegion titlescreen;
    public static TextureRegion credits;
    public static TextureRegion golfBall;
    
    public static Sound hole;
    public static Sound swing;
    public static Sound theme;
    /**
     * Loads all the assets that well be used
     */
    public static void load(){
    ts = new Texture(Gdx.files.internal("MainMenu.png"));
    ts.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
    titlescreen = new TextureRegion(ts);
    titlescreen.flip(true,false);    
        
    lvl1 = new Texture(Gdx.files.internal("lvl1.png"));
    lvl1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
    backGround1 = new TextureRegion(lvl1);
    backGround1.flip(true,false);
    
    lvl2 = new Texture(Gdx.files.internal("lvl2.png"));
    lvl2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
    backGround2 = new TextureRegion(lvl2);
    backGround2.flip(true,false);
    
   // lvl3 = new Texture(Gdx.files.internal("lvl3.png"));
   // lvl3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
  //  backGround3 = new TextureRegion(lvl3);
  //  backGround3.flip(true,false);
    
    //credit = new Texture(Gdx.files.internal("credits.png"));
   // credit.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
   // credits = new TextureRegion(credit);
   // credits.flip(false,true);
    
    ball = new Texture(Gdx.files.internal("ball.png"));
    ball.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
    golfBall = new TextureRegion(ball,0,0,32,32);
    golfBall.flip(true, false);
    
    hole = Gdx.audio.newSound(Gdx.files.internal("hole.mp3"));
    swing = Gdx.audio.newSound(Gdx.files.internal("Golf Club Swing.wav"));
    theme = Gdx.audio.newSound(Gdx.files.internal("Modigs - OARFISH_228090209_soundcloud.mp3"));
    }
    /**
     * Disposes of assets no longer needed
     */
    public static void dispose() {
        ts.dispose();
        lvl1.dispose();
        lvl2.dispose();
        //lvl3.dispose();
        ball.dispose();
    }

}
