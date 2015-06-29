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
        
        dimension.x = Constants.RIGHT_BOUND-Constants.LEFT_BOUND;
        dimension.y = Constants.TOP_BOUND-Constants.BOTTOM_BOUND;
        position.x = Constants.LEFT_BOUND;
        position.y = Constants.BOTTOM_BOUND;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(backReg, position.x, position.y, dimension.x, dimension.y);
    }
}
