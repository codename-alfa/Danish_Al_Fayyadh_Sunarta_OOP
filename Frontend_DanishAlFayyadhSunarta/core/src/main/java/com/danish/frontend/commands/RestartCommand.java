package com.danish.frontend.commands;

import com.danish.frontend.GameManager;
import com.danish.frontend.Player;

public class RestartCommand implements Command{
    private Player player;
    private GameManager gameManager;

    public RestartCommand(Player player, GameManager gameManager){
        this.player = player;
        this. gameManager = gameManager;
    }

    @Override
    public void execute(){
        player.reset();
        gameManager.setScore(0);
    }
}
