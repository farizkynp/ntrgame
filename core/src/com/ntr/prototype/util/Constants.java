/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.util;

import com.badlogic.gdx.Gdx;

/**
 *
 * @author Lenovo
 */
public class Constants {
    //visible game world
    public static final float VIEWPORT_WIDTH = 5.0f;
    public static final float VIEWPORT_HEIGHT = 5.0f;
    
    
    public static final float VIEWPORT_GUI_HEIGHT = 720.0f;
    public static final float VIEWPORT_GUI_WIDTH = VIEWPORT_GUI_HEIGHT*16/9;
    
    public static final String ATLAS_OBJECT = "ntr.pack";
    
    public enum State{
        A,B
    }
    
    
    public static float getWidth(){
        return VIEWPORT_HEIGHT/Gdx.graphics.getHeight()*Gdx.graphics.getWidth();
    }
    
    public static float getHeight(){
        return VIEWPORT_HEIGHT;
    }
}
