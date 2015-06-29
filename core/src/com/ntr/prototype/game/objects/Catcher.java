/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.game.objects;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ntr.prototype.util.Constants;
import com.ntr.prototype.game.Assets;
/**
 *
 * @author Lenovo
 */
public class Catcher extends AbstractGameObject {

    private final float yPosition;
    private TextureRegion textureRegA, textureRegB;
    public Constants.State state;

    float bound1 = Constants.LEFT_BOUND ;
    float bound2 = Constants.RIGHT_BOUND - 0.365f;

    public Catcher(float yPosition) {
        this.yPosition = yPosition;
        init();
    }

    private void init() {
        dimension.set(0.35f, 0.5f);
        velocity.x = 0.05f;
        state = Constants.State.A;

        Pixmap pixmapB = new Pixmap(32, 32, Pixmap.Format.RGBA8888);
        pixmapB.setColor(0, 1, 0, 1);
        pixmapB.fill();
        textureRegA = Assets.instance.catcher.catcher;
        textureRegB = new TextureRegion(new Texture(pixmapB));
        pixmapB.dispose();

        position.y = yPosition - dimension.y / 2;
        position.x = -Constants.getWidth() / 4 + dimension.x / 2  + 0.15f;
        bounds.set(position.x, yPosition, dimension.x, dimension.y/5);
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion textureReg;
        switch (state) {
            case A:
                textureReg = textureRegA;
                break;
            default:
                textureReg = textureRegB;
                break;
        }

        batch.draw(textureReg.getTexture(), position.x + origin.x, position.y + origin.y,
                origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation,
                textureReg.getRegionX(), textureReg.getRegionY(),
                textureReg.getRegionWidth(), textureReg.getRegionHeight(),
                false, false);
    }

    public void moveLeft() {
        if (position.x >= bound1) {
            position.x -= velocity.x;
        }
        updateBound();
    }

    public void moveRight() {
        if (position.x <= bound2) {
            position.x += velocity.x;
        }
        updateBound();
    }

}
