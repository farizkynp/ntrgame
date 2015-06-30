/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.ntr.prototype.util.Constants;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class WorldRenderer implements Disposable{

    private OrthographicCamera camera;
    private OrthographicCamera cameraGUI;
    private SpriteBatch batch;
    private WorldController worldController;
    public BitmapFont font;
    
    public WorldRenderer(WorldController worldController){
        this.worldController = worldController;
        init();
    }
    
    private void init(){
        batch = new SpriteBatch();
        font = new BitmapFont();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, 
                Constants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();
//        cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH,
//                Constants.VIEWPORT_GUI_HEIGHT);
        cameraGUI = new OrthographicCamera();
//        cameraGUI.position.set(0, 0, 0);
        cameraGUI.setToOrtho(false,720*16/9,720);
        cameraGUI.update();
    }
    public void render(){
        
        renderLevel(batch);
        renderGUI(batch);
    }
    public void resize(int width, int height){
        camera.viewportWidth= (Constants.VIEWPORT_HEIGHT/height)*width;
        camera.update();
//        cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;
//        cameraGUI.viewportWidth= (Constants.VIEWPORT_HEIGHT/height)*(float)width;
//        cameraGUI.position.set(cameraGUI.viewportWidth/2, 
//                cameraGUI.viewportHeight/2 ,0);
        cameraGUI.update();
    }
    
    @Override
    public void dispose() {
        font.dispose();
        batch.dispose();
    }
    
    private void renderLevel(SpriteBatch batch){
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        worldController.level.render(batch);      
        batch.end();
    }
    
    private void renderGUI(SpriteBatch batch){
        batch.setProjectionMatrix(cameraGUI.combined);
        batch.begin();
        renderGUIIndicator(batch);
        renderGUIScore(batch);
        batch.end();
    }
    
    private void renderGUIScore(SpriteBatch batch){
        float x = 420;
        float y = 715;
        font.draw(batch, "Score", x-30, y);
        font.draw(batch, "" + worldController.score, x, y-20);
    }
    
    private void renderGUIIndicator(SpriteBatch batch){
        float x = 40;
        float yYellow = 40;
        float yBlue = 40;
        float yGreen = 40;
        float y = 665;
        switch (worldController.level.catcher.state){
            case A:
                yYellow = 705;
                yBlue = 665;
                yGreen = 705;break;
            case B:
                yYellow = 665;
                yBlue = 705;
                yGreen = 705;break;
                
        }
        //top border
        batch.setColor(0, 0, 0, 1);
        batch.draw(Assets.instance.catcher.catcher, 0, 660, 960, 100);
        
        //rendering indicator
        batch.setColor(1, 1, 0, 1);
        batch.draw(Assets.instance.catcher.catcher, x, yYellow, 80, 100);
        batch.setColor(0, 0, 1, 1);
        batch.draw(Assets.instance.catcher.catcher, x+80, yBlue, 80, 100);
        batch.setColor(0, 1, 0, 1);
        batch.draw(Assets.instance.catcher.catcher, x+160, yGreen, 80, 100);
        batch.setColor(1, 1, 1, 1);
    }
    
}
