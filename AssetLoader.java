/**
 * Daniel Ross
 */

package com.egs.golfhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/**
 *
 * @author daros0591
 */
public class AssetLoader {
    public static Texture bg, ball;
    
    public static TextureRegion backGround;
    public static TextureRegion golfBall;
    
    public static void load(){
        
    bg = new Texture(Gdx.files.internal("Grass1.png"));
    bg.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
    backGround = new TextureRegion(bg);
    backGround.flip(true,false);
    
    ball = new Texture(Gdx.files.internal("ball.png"));
    ball.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    
    golfBall = new TextureRegion(ball);
    golfBall.flip(true, false);
    }
    
    public static void dispose() {
        bg.dispose();
        ball.dispose();
    }

}
