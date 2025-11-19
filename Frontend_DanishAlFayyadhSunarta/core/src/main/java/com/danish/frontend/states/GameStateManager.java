package com.danish.frontend.states;

import java.util.Stack;

public class GameStateManager{
    public GameStateManager() {
        states = new Stack<>();
    }
    private final Stack<GameState> states;
    public void push(GameState state){
        states.push(state);
    }
    public void pop(){

    }
    public void set(GameState state){
        pop();
        push(state);
    }
    public void update(float delta){
        states.peek().update(delta);
    }
}
