package com.danish.frontend.pools;

import com.badlogic.gdx.Gdx;
import com.danish.frontend.obstacles.HorizontalLaser;
import com.badlogic.gdx.math.Vector2;

public class HorizontalLaserPool extends ObjectPool<HorizontalLaser>{
    @Override
    public HorizontalLaser createObject(){
        return new HorizontalLaser(new Vector2(Gdx.graphics.getWidth(), 0), 100);
    }
    @Override
    protected void resetObject(HorizontalLaser object) {
        object.setPosition(Gdx.graphics.getWidth(), 0);
        object.setActive(false);
    }
    public HorizontalLaser obtain(Vector2 position, int length) {
        HorizontalLaser horizontalLaser = super.obtain();
        horizontalLaser.initialize(position, length);
        horizontalLaser.setActive(true);
        return horizontalLaser;
    }
}
