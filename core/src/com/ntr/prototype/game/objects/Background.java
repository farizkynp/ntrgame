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

public class Background extends AbstractGameObject{
    
    private TextureRegion backReg;
    
    public Background(){
        init();
    }
    
    public void init(){   
        backReg = Assets.instance.background.back1;    
        
        dimension.x = Constants.getWidth()*5/8;
        dimension.y = Constants.getHeight();
        position.x = -Constants.getWidth()/2;
        position.y = -Constants.getHeight()/2;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(backReg, position.x, position.y, dimension.x, dimension.y);
    }
}
