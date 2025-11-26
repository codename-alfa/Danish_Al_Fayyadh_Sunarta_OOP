package com.danish.frontend;

import com.badlogic.gdx.Gdx;
import com.danish.frontend.observers.Observer;
import com.danish.frontend.observers.ScoreManager;
import com.danish.frontend.services.BackendService;

public class GameManager{
    private static GameManager instance;
    private ScoreManager scoreManager;
    private boolean gameActive;
    private BackendService backendService;
    private String currentPlayerId = null;
    private int coinsCollected = 0;

    private GameManager(){
        scoreManager = new ScoreManager();
        gameActive = false;
        backendService = new BackendService();
    }
    public static GameManager getInstance(){
        if(instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
    public void startGame(){
        scoreManager.setScore(0);
        gameActive = true;
        System.out.println("Game Started!");
        coinsCollected = 0;
    }

    public void setScore(int newScore){
        if (gameActive) {
            scoreManager.setScore(newScore);
        }
    }

    public int getScore(){
        return scoreManager.getScore();
    }
    public void addObserver(Observer observer){
        scoreManager.addObserver(observer);
    }
    public void removeObserver(Observer observer){
        scoreManager.removeObserver(observer);
    }
    public void registerPlayer(String username){
        backendService.createPlayer(username, new BackendService.RequestCallback());
    }
    public void endGame(){
        if(currentPlayerId == null){
            Gdx.app.error(,);
            return;
        }
        int finalScore = scoreManager.getScore() + coinsCollected * 10;
        int distance = scoreManager.getScore();
        backendService.submitScore(currentPlayerId, finalScore, coinsCollected, distance, );
    }
}
