/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
        
        renderGUI(batch);
        renderLevel(batch);
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
        renderGUIScore(batch);
        batch.end();
    }
    
    private void renderGUIScore(SpriteBatch batch){
        float x = 20;
        float y = 715;
        font.draw(batch, "" + worldController.score, x, y);
    }
    
}
