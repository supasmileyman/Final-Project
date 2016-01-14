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
import com.egs.gameobjects.Ball;
import com.egs.golfhelpers.AssetLoader;

public class GameRenderer {

    private Ball ball;
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;

    private Texture background1;
    private Texture background2;
    private Texture background3;
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

        //Intialize the instance variables
        initializeGameObjects();
        initializeAssets();
    }

    public void initializeGameObjects() {
        ball = myWorld.getBall();
    }

    public void initializeAssets() {
        background1 = AssetLoader.lvl1;
        background2 = AssetLoader.lvl2;
        //  background2 = AssetLoader.lvl3;
        golfBall = AssetLoader.ball;
    }

    public void render() {
        // Gdx.app.log("GameRenderer", "render");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Draw the images
        //If it is lvl1 display level1 else display the correct level
        if (ball.getLvl() == 1) {
            batch.begin();
            batch.disableBlending();
            batch.draw(background1, 0, 0, 1024, 512);
            batch.draw(golfBall, ball.getX(), ball.getY());
        } else if (ball.getLvl() == 2) {
            batch.begin();
            batch.disableBlending();
            batch.draw(background2, 0, 0, 1024, 512);
            batch.draw(golfBall, ball.getX(), ball.getY());
        } else if (ball.getLvl() == 3) {
          //  batch.begin();
            //  batch.disableBlending();
            //  batch.draw(background3, 0, 0, 1024, 512);
            //  batch.draw(golfBall, ball.getX(), ball.getY());
        }
        batch.enableBlending();
        batch.end();
    }
}
