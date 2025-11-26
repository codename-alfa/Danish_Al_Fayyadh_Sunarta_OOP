package com.danish.frontend;

import java.util.ArrayList;

public class ScoreSystem{
    public ArrayList<ScoreObserver> observers;
    public int score;

    public ScoreSystem() {
        this.observers = new ArrayList<>();
        this.score = 0;
    } // error di main kalo ga dibikin constructor

    public void registerObserver(ScoreObserver observer){
        observers.add(observer);
    }
    public void removeObserver(ScoreObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for(ScoreObserver observer : observers){
            observer.onScoreUpdate(score);
        }
    }
    public void addScore(int amount){
        score += amount;
        notifyObservers();
    }
}
