/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.ntr.prototype.game.objects.Catcher;
import com.ntr.prototype.game.objects.Gas;
import com.ntr.prototype.game.objects.Pipe;
import com.ntr.prototype.game.objects.Tank;
import com.ntr.prototype.game.objects.Background;
import com.ntr.prototype.util.Constants;
import java.util.Iterator;

/**
 *
 * @author Lenovo
 */
public class Level {
    public static final String TAG = Level.class.getName();
    
    public Pipe pipe;
    public Catcher catcher;
    public Tank tank;
    public Array<Gas> gases;
    public Background back;
    
    private long lastDropTime;
    
    public Level(){
        init();
    }
    
    private void init(){
        pipe = new Pipe(1.85f);
        catcher = new Catcher(1.85f);
        tank = new Tank();
        gases = new Array<Gas>();
        back = new Background();
        spawnGas();
    }
    
    public void render(SpriteBatch batch){
        float bound = Constants.getHeight()/2;        
        if(TimeUtils.nanoTime() - lastDropTime > 1000000000){
            spawnGas();
        }
        back.render(batch);
        pipe.render(batch);        
        for(Gas g : gases){
            g.render(batch);
        }
        catcher.render(batch);
        tank.render(batch);
        Iterator<Gas> iter = gases.iterator();
        while(iter.hasNext()){
            Gas g = iter.next();
            g.moveUp();
            if(g.position.y>bound){
                iter.remove();
            }
        }
    }
    
    private void spawnGas() {
      float bound1 = Constants.LEFT_BOUND;
      float bound2 = Constants.RIGHT_BOUND-0.35f;
      float xPosition = MathUtils.random(bound1, bound2);                      
      Gas gas = new Gas(xPosition);
      gases.add(gas);
      lastDropTime = TimeUtils.nanoTime();
   }
}
