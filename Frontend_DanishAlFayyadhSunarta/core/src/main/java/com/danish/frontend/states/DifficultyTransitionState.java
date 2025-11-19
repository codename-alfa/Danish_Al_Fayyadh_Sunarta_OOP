package com.danish.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danish.frontend.strategies.DifficultyStrategy;

public class DifficultyTransitionState implements GameState{
    private final GameStateManager gsm;
    private final PlayingState playingState;
    private final DifficultyStrategy newStrategy;
    private final BitmapFont font;
    private float timer = 2.0f;

    public DifficultyTransitionState(GameStateManager gsm, PlayingState playingState, DifficultyStrategy newStrategy) {
        this.gsm = gsm;
        this.playingState = playingState;
        this.newStrategy = newStrategy;
        this.font = new BitmapFont();
    }
    @Override
    public void update(float delta) {
        timer -= delta;
        if(timer <= 0){
            playingState.setDifficulty(newStrategy);
            gsm.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        playingState.render(batch);
        batch.begin();
        font.draw(batch, "DIFFICULTY INCREASED!", (width / 2f) - 10f, (height / 2f) + 15f);
        font.draw(batch, "Difficulty: " + newStrategy.getClass().getSimpleName(), (width / 2f) - 10f, (height / 2f) - 15f);
        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
