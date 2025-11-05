package com.danish.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.danish.frontend.obstacles.HomingMissile;

public class HomingMissilePool extends ObjectPool<HomingMissile>{
    @Override
    protected HomingMissile createObject(){
        return new HomingMissile(new Vector2(0, 0));
    }
    @Override
    protected void resetObject(HomingMissile object){
        object.setPosition(0, 0);
        object.setTarget(null);
        object.setActive(false);
    }
    public HomingMissile obtain(Vector2 position){
        HomingMissile homingMissile = super.obtain();
        homingMissile.initialize(position, 0);
        homingMissile.setActive(true);
        return homingMissile;
    }
}
