package com.danish.frontend;

import com.danish.frontend.observers.Observer;

public class GameManager{
    private static GameManager instance;
    private int scoreManager;
    private boolean gameActive;

    private GameManager(){
        scoreManager = 0;
        gameActive = false;
    }
    public static GameManager getInstance(){
        if(instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
    public void startGame(){
        scoreManager = 0;
        gameActive = true;
        System.out.println("Game Started!");
    }

    public void setScore(int newScore){
        if (gameActive) {
            this.scoreManager = newScore;
        }
    }

    public int getScore(){
        return scoreManager;
    }
    public void addObserver(Observer observer){
        scoreManager.addObserver();
    }
    public void  removeObserver{

    }
}
