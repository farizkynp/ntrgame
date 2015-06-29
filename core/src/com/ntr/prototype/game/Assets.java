/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntr.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;
import com.ntr.prototype.util.Constants;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class Assets implements Disposable, AssetErrorListener{
    public static final String TAG = Assets.class.getName();
    
    public static final Assets instance = new Assets();
    
    private AssetManager assetManager;    
    public AssetCatcher catcher;
    public AssetGas gas;
    public AssetDecoration decoration;
    public AssetBackground background;
    
    private Assets(){}
    
    public void init(AssetManager assetManager){
        this.assetManager = assetManager;
        
        assetManager.setErrorListener(this);
        
        assetManager.load(Constants.ATLAS_OBJECT, TextureAtlas.class);
        //not completed
        assetManager.finishLoading();
        
        Gdx.app.debug(TAG, "# of assets loaded: "+assetManager.getAssetNames().size);
        for(String a:assetManager.getAssetNames()){
            Gdx.app.debug(TAG, "assets : "+a);
        }
        
        TextureAtlas atlas = assetManager.get(Constants.ATLAS_OBJECT);
        
        for(Texture t : atlas.getTextures()){
            t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        }
        
        catcher = new AssetCatcher(atlas);
        decoration = new AssetDecoration(atlas);
        gas = new AssetGas(atlas);
        background = new AssetBackground(atlas);
    }
    
    @Override
    public void dispose(){
        assetManager.dispose();
    }
    
    public void error(String filename, Class type, Throwable throwable){
        Gdx.app.error(TAG, "Couldn't load asset '"+filename+"'",
                (Exception)throwable);
    }
    
    @Override
    public void error(AssetDescriptor asset, Throwable throwable){
        Gdx.app.error(TAG, "Couldn't load asset '"+asset.fileName+"'",
                (Exception)throwable);
    }
    
    public class AssetCatcher{
        public final AtlasRegion catcher;
        
        public AssetCatcher(TextureAtlas atlas){
            catcher = atlas.findRegion("catcher");
        }
    }
    
    public class AssetGas{
        public final AtlasRegion blue;
        public final AtlasRegion green;
        public final AtlasRegion yellow;
        
        public AssetGas(TextureAtlas atlas){
            blue = atlas.findRegion("blue");
            green = atlas.findRegion("green");
            yellow = atlas.findRegion("yellow");
        }
    }
    
    public class AssetDecoration{
        public final AtlasRegion pipe;
        public final AtlasRegion tank;
        
        public AssetDecoration(TextureAtlas atlas){
            pipe = atlas.findRegion("pipe");
            tank = atlas.findRegion("alas");
        }
    }
    
    public class AssetBackground{
        public final AtlasRegion back1;
        
        public AssetBackground(TextureAtlas atlas){
            back1 = atlas.findRegion("back");
        }
    }
    
}
