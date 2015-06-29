/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ntr.prototype.util.Constants;
import com.ntr.prototype.game.Assets;
import com.badlogic.gdx.math.MathUtils;

/**
 *
 * @author Lenovo
 */
public class Gas extends AbstractGameObject{
    
    private final float xPosition;
    public boolean collected;
    private TextureRegion gasReg;
    public Constants.State state;
    
    public Gas(float xPosition){
        this.xPosition = xPosition;
        init();
    }
    
    private void init(){
        dimension.set(0.35f , 0.35f);
        velocity.y = MathUtils.random(0.005f, 0.01f);
        
        int x = MathUtils.random(0, 1);
        if(x==0){            
            gasReg = Assets.instance.gas.blue;
            state=Constants.State.A;
        }
        else{
            gasReg = Assets.instance.gas.yellow;
            state=Constants.State.B;            
        }
        position.x = xPosition;
        position.y = -Constants.getHeight()/2;        
        bounds.set(position.x, position.y, dimension.x, dimension.y);
    }

    @Override
    public void render(SpriteBatch batch) {
        if(collected){
            return;
        }
        batch.draw(gasReg.getTexture(), position.x+origin.x, position.y+origin.y,
                origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, 
                gasReg.getRegionX(), gasReg.getRegionY(), 
                gasReg.getRegionWidth(), gasReg.getRegionHeight(), 
                false, false);
    }
    
    public void moveUp(){
        position.y+=velocity.y;
        updateBound();
    }
    
}
