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
import com.egs.player.Score;
import java.util.ArrayList;
import javax.swing.*;

public class GameRenderer {

    private Ball ball;
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;

    private Texture startMenu;
    private Texture background1;
    private Texture background2;
    private Texture background3;
    private Texture golfBall;
    private int midPointY;
    private int gameHeight;

    private BitmapFont font;

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

        font = new BitmapFont(true);

        //Intialize the instance variables
        initializeGameObjects();
        initializeAssets();
    }

    public void initializeGameObjects() {
        ball = myWorld.getBall();
    }

    public void initializeAssets() {
        startMenu = AssetLoader.titlescreen;
        background1 = AssetLoader.backGround1;
        background2 = AssetLoader.backGround2;
        //  background3 = AssetLoader.backGround3;
        //  background3 = AssetLoader.backGround4;
        credit = AssetLoader.credits;
        golfBall = AssetLoader.golfBall;
    }

    public void render() {
        // Gdx.app.log("GameRenderer", "render");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        //Draw the images
        //If it is lvl1 display level1 else display the correct level
        batch.begin();
            batch.enableBlending();
        if (ball.getLvl() == 0){
            batch.draw(startMenu, 0, 0, 1024, 512);
        } else if (ball.getLvl() == 1) {
            batch.draw(background1, 0, 0, 1024, 512);
            batch.draw(golfBall, ball.getX(), ball.getY());
            font.draw(batch, "Hits: " + ball.getScore(), 900, 500);
            font.draw(batch, "Level: " + ball.getLvl(), 800, 500);
        } else if (ball.getLvl() == 2) {
            batch.draw(background2, 0, 0, 1024, 512);
            batch.draw(golfBall, ball.getX(), ball.getY());
            font.draw(batch, "Hits: " + ball.getScore(), 900, 500);
            font.draw(batch, "Level: " + ball.getLvl(), 800, 500);
        } else if (ball.getLvl() == 3) {
            //  batch.draw(background3, 0, 0, 1024, 512);
            //  batch.draw(golfBall, ball.getX(), ball.getY());
           // font.draw(batch, "Hits: " + ball.getScore(), 900, 500);
          //  font.draw(batch, "Level: " + ball.getLvl(), 800, 500);
        }else if (ball.getLvl() == 20){
            String choice = JOptionPane.showInputDialog(null, "Enter 1 to see top 5 scores, 2 to search highscores, 3 to return to main menu.", "1");
            if (choice.equals("1")) {
                ArrayList<String> top = new ArrayList();
                Score.load();
                top = Score.getAllScores();
                JOptionPane.showMessageDialog(null, "Top Scores in Eddie's Golf Simulator:\nName\tScore\n1: " + top.get(0) +
                    "\n2: " + top.get(1) +
                    "\n3: " + top.get(2) +
                    "\n4: " + top.get(3) +
                    "\n5: " + top.get(4));
                ball.setLvl(0);
            }else if (choice.equals("2")) {
                Score.searchScores();
                ball.setLvl(0);
            }else if (choice.equals("3") {
                ball.setLvl(0);
            }else {
                JOptionPane.showMessageDialog(null, "Error! Returning to main menu.");
                ball.setLvl(0);
            }
        }else if (ball.getLvl() == 21){
        batch.draw(credit, 0, 0, 1024, 512);
        font.draw(batch, "Ji Lin", 200, 350);
        }

        batch.end();
    }
}
