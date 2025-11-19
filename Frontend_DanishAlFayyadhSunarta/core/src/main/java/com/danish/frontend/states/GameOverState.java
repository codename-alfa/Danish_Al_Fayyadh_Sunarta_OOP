package com.danish.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState implements GameState{
    private final GameStateManager gsm;
    private final BitmapFont font;

    public GameOverState(GameStateManager gsm){
        this.gsm = gsm;
        this.font = new BitmapFont();
    }

    @Override
    public void update(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            gsm.set(new PlayingState(gsm));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        batch.begin();
        font.draw(batch, "GAME OVER", width / 2f, (height / 2f) + 15f);
        font.draw(batch, "Press SPACE to restart", width / 2f, (height / 2f) - 15f);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}
