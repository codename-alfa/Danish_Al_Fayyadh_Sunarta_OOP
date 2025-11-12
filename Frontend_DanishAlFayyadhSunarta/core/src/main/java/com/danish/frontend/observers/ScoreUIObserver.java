package com.danish.frontend.observers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreUIObserver implements Observer{
    private BitMapFont font;
    private SpriteBatch batch;

    public ScoreUIObserver(){
        this.font = new BitmapFont();

        this.batch = new SpriteBatch();
    }


    @Override
    public void update(int score) {
        System.out.println("Score updated!");
    }
    public void render(int score){

    }
    public void dispose(){
        font.release();
        batch.release();
    }
}
