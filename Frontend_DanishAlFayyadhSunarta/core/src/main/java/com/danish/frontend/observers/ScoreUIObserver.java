package com.danish.frontend.observers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;

public class ScoreUIObserver implements Observer{
    private BitmapFont font;
    private SpriteBatch batch;

    public ScoreUIObserver(){
        this.font = new BitmapFont();
        this.font.setColor(Color.WHITE);
        this.batch = new SpriteBatch();
    }
    @Override
    public void update(int score) {
        System.out.println("Score updated!\nScore: " + score);
    }
    public void render(int score, int coins){
        batch.begin();
        font.draw(batch, "Score: " + score, 20, com.badlogic.gdx.Gdx.graphics.getHeight() - 20);
        font.draw(batch, "Coins: " + coins, 20, com.badlogic.gdx.Gdx.graphics.getHeight() - 60);
        batch.end();
    }
    public void dispose(){
        font.dispose();
        batch.dispose();
    }
}
