/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype;

import com.badlogic.gdx.ApplicationListener;
import com.ntr.prototype.game.WorldController;
import com.ntr.prototype.game.WorldRenderer;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.assets.AssetManager;
import com.ntr.prototype.game.Assets;

public class NTRPrototypeMain implements ApplicationListener{
    
    private static final String TAG = NTRPrototypeMain.class.getName();
    
    private WorldController worldController;
    private WorldRenderer worldRenderer;

    @Override
    public void create() {
        //set log level to debug
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        
        Assets.instance.init(new AssetManager());
        //initialisasi controller dan renderer
        worldController = new WorldController();
        worldRenderer = new WorldRenderer(worldController);
    }

    @Override
    public void resize(int width, int height) {
        worldRenderer.resize(width, height);
    }

    @Override
    public void render() {
        //update game world 
        worldController.update(Gdx.graphics.getDeltaTime());
        //clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 0);
        //clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //render game world to screen
        worldRenderer.render();
    }

    @Override
    public void pause() {
        }

    @Override
    public void resume() {
        }

    @Override
    public void dispose() {
        worldRenderer.dispose();        
        Assets.instance.dispose();
    }
    
}
