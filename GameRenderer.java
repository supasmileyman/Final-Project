/*
 * Daniel Ross
 */
package com.egs.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.egs.gameobjects.Ball;
import com.egs.golfhelpers.AssetLoader;

public class GameRenderer {
    
    private Ball ball;
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;
    
    private Texture background;
    private Texture golfBall;
    private int midPointY;
    private int gameHeight;

    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        myWorld = world;
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 1024, gameHeight);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        // Call helper methods to initialize instance variables
        initializeGameObjects();
        initializeAssets();
    }

    public void initializeGameObjects(){
        ball = myWorld.getBall();
    }
    
    public void initializeAssets(){
        background = AssetLoader.bg;
        golfBall = AssetLoader.ball;
    }
    
    public void render() {
        Gdx.app.log("GameRenderer", "render");
       // Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        
        batch.begin();
        batch.disableBlending();
        batch.draw(background, 0, midPointY - 23, 10, 10);
        batch.draw(golfBall, ball.getX(), ball.getY());
        
        batch.enableBlending();
        batch.end();
        
    }

}
