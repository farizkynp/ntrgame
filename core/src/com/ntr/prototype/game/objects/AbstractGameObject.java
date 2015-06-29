/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public abstract class AbstractGameObject {
    
    public Vector2 position;
    public Vector2 dimension;
    public Vector2 origin;
    public Vector2 scale;
    public float rotation;
    public Vector2 velocity;
    public Rectangle bounds;
    
    public AbstractGameObject(){
        position = new Vector2();
        dimension = new Vector2(1, 1);
        origin = new Vector2();
        scale = new Vector2(1, 1);
        rotation = 0;
        velocity = new Vector2();
        bounds = new Rectangle();
    }
    
    public void update(float deltaTime){
    }
    
    public abstract void render(SpriteBatch batch);
    
    
    
    public void updateBound(){
        bounds.set(position.x, position.y, dimension.x, dimension.y);
    }
}
