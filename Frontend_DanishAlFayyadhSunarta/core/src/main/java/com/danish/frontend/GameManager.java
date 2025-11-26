package com.danish.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
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

    public void setScore(int distance){
        if (gameActive) {
            scoreManager.setScore(distance);
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
        backendService.createPlayer(username, new BackendService.RequestCallback(){
            @Override
            public void onSuccess(String response) {
                try {
                    JsonValue json = new JsonReader().parse(response);
                    currentPlayerId = json.getString("playerId");
                    Gdx.app.log("GameManager", "currentPlayerId saved: " + currentPlayerId);
                } catch (Exception e) {
                    Gdx.app.error("GameManager", "error: " + e.getMessage());
                }
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "error: " + error);
            }
        });
    }
    public void endGame(){
        if(currentPlayerId == null){
            Gdx.app.error("GameManager","error");
            return;
        }
        int finalScore = scoreManager.getScore() + coinsCollected * 10;
        int distance = scoreManager.getScore();
        backendService.submitScore(currentPlayerId, finalScore, coinsCollected, distance,  new BackendService.RequestCallback(){
            @Override
            public void onSuccess(String response) {
                Gdx.app.log("GameManager", "score: " + response);
            }
            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "error: " + error);
            }
        });
    }
    public void addCoin() {
        coinsCollected++;
        Gdx.app.log("GameManager", "COIN COLLECTED! Total: " + coinsCollected);
    }
    public int getCoins(){
        return coinsCollected;
    }
}
