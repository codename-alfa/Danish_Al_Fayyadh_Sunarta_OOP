package com.danish.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.danish.frontend.Coin;

public class CoinPool extends ObjectPool<Coin>{
    @Override
    protected Coin createObject() {
        return new Coin(new Vector2(0,0));
    }

    @Override
    protected void resetObject(Coin object) {
        Coin.setActive(false);
    }

    public  obtain(float x, float y){
        Object coin;
        super.obtain();

        return ;
    }
}
