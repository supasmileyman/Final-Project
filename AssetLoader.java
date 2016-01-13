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
    public static Texture bg, ball, ts;
    
    public static TextureRegion backGround;
    public static TextureRegion titlescreen;
    public static TextureRegion golfBall;
    
    public static Sound hole;
    public static Sound swing;
    
    public static void load(){
    ts = new Texture(Gdx.files.internal("MainMenu.png"));
    ts.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
    titlescreen = new TextureRegion(ts);
    titlescreen.flip(true,false);    
        
    bg = new Texture(Gdx.files.internal("Grass1.png"));
    bg.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
    backGround = new TextureRegion(bg);
    backGround.flip(true,false);
    
    ball = new Texture(Gdx.files.internal("ball.png"));
    ball.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
    golfBall = new TextureRegion(ball);
    golfBall.flip(true, false);
    
    hole = Gdx.audio.newSound(Gdx.files.internal("hole.mp3"));
    swing = Gdx.audio.newSound(Gdx.files.internal("Golf Club Swing.wav"));
    }
    
    public static void dispose() {
        bg.dispose();
        ball.dispose();
    }

}
