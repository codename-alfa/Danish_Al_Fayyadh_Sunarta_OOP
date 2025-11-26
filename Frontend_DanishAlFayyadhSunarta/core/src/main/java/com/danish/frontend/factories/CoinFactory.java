package com.danish.frontend.factories;

import com.danish.frontend.Coin;
import com.danish.frontend.pools.CoinPool;

import java.util.List;
import java.util.Random;

public class CoinFactory {
    private CoinPool coinPool;
    private Random random;

    public CoinFactory() {
        this.coinPool = new CoinPool();
        this.random = new Random();
    }

    public void createCoinPattern(float spawnX, float groundTopY){
        if(random.nextFloat() < 0.3f){
            for(int i = 0; i < 3; i++){
                coinPool.obtain(spawnX + (i * 40f), groundTopY + 50f);
            }
        }
    }
    public List<Coin> getActiveCoins(){
        return coinPool.getInUse();
    }
    public void releaseCoin(Coin coin){
        coinPool.release(coin);
    }
    public void releaseAll() {
        coinPool.releaseAll();
    }
}
