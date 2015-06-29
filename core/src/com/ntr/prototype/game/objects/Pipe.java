/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.game.objects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ntr.prototype.game.Assets;
import com.ntr.prototype.util.Constants;

public class Pipe extends AbstractGameObject{
    
    private final float yPosition;
    private TextureRegion pipeReg;
    
    public Pipe(float yPosition){
        this.yPosition = yPosition;
        init();
    }
    
    private void init(){
        dimension.set(1 ,0.25f);        
        pipeReg = Assets.instance.decoration.pipe;      
        position.x = Constants.LEFT_BOUND;
        dimension.x = Constants.RIGHT_BOUND-Constants.LEFT_BOUND;  
        position.y = yPosition-dimension.y/2;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(pipeReg.getTexture(), position.x+origin.x, position.y+origin.y,
                origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, 
                pipeReg.getRegionX(), pipeReg.getRegionY(), 
                pipeReg.getRegionWidth(), pipeReg.getRegionHeight(), 
                false, false);
    }  
    
}
