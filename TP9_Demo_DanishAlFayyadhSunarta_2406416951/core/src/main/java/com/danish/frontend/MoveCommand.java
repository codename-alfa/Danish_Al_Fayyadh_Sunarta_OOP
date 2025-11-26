package com.danish.frontend;

public class MoveCommand implements Command{
    public Player player;
    public  float dx, dy;

    public MoveCommand(Player player, float dx, float dy) {
        this.player = player;
        this.dx = dx;
        this.dy = dy;
    } // error di main kalo ga dibikin constructor

    @Override
    public void execute(){
        player.move(dx, dy);
    }
}
