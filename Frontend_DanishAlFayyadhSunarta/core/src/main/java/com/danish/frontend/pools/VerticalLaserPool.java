package com.danish.frontend.pools;

import com.badlogic.gdx.Gdx;
import com.danish.frontend.obstacles.VerticalLaser;
import com.badlogic.gdx.math.Vector2;

public class VerticalLaserPool extends ObjectPool<VerticalLaser>{
    @Override
    public VerticalLaser createObject(){
        return new VerticalLaser(new Vector2(Gdx.graphics.getWidth(), 0), 100);
    }
    @Override
    protected void resetObject(VerticalLaser object){
        object.setPosition(Gdx.graphics.getWidth(), 0);
        object.setActive(false);
    }
    public VerticalLaser obtain(Vector2 position, int length){
        VerticalLaser verticalLaser = super.obtain();
        verticalLaser.initialize(position, length);
        verticalLaser.setActive(true);
        return verticalLaser;
    }
}
