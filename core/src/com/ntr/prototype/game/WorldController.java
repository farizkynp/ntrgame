/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.ntr.prototype.game.objects.Gas;
import com.ntr.prototype.util.Constants;

public class WorldController {
    
    private static final String TAG = WorldController.class.getName();
    
    public Level level;
    public int score;
    
    private Rectangle r1 = new Rectangle();
    private Rectangle r2 = new Rectangle();
       
    public WorldController(){
        init();
    }
    
    private void init(){
        score = 0;
        initLevel();
    }
    
    public void update(float deltaTime){
        handleInput(deltaTime);
        testCollision();
    }
    
    private void handleInput(float deltaTime){
        if(Gdx.input.isKeyPressed(Keys.LEFT)){
            level.catcher.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)){
            level.catcher.moveRight();
        }
        if(Gdx.input.isKeyPressed(Keys.S)){
            level.catcher.state = Constants.State.A;
        }
        if(Gdx.input.isKeyPressed(Keys.A)){
            level.catcher.state = Constants.State.B;
        }
    }
    
    private void initLevel(){
        level = new Level();
    }
    
    private void testCollision(){
        r1.set(level.catcher.position.x, level.catcher.position.y,
                level.catcher.bounds.width, level.catcher.bounds.height);
        
        for(Gas g : level.gases){
            r2.set(g.position.x, g.position.y, g.bounds.width, g.bounds.height);
            if(!r1.overlaps(r2)){
                continue;
            }
            onCollisionCatcherWithGas(g);
        }
        
        
    }
    
    private void onCollisionCatcherWithGas(Gas g){
//        Gdx.app.log(TAG, "Gas Collected");
        if(level.catcher.state==g.state&&!g.collected){
            score++;
//            System.out.println(score);
        }
        g.collected=true;
    }
}
