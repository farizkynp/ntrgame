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

public class Tank extends AbstractGameObject{
    
    private TextureRegion tankReg;
    
    public Tank(){
        init();
    }
    
    public void init(){
        dimension.set(1 ,0.25f);        
        tankReg = Assets.instance.decoration.tank;
        
        dimension.x = Constants.RIGHT_BOUND-Constants.LEFT_BOUND;
        dimension.y = Constants.getHeight()/6;
        position.x = Constants.LEFT_BOUND;
        position.y = -Constants.getHeight()/2;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(tankReg.getTexture(), position.x+origin.x, position.y+origin.y,
                origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, 
                tankReg.getRegionX(), tankReg.getRegionY(), 
                tankReg.getRegionWidth(), tankReg.getRegionHeight(), 
                false, false);
    }
    
}
