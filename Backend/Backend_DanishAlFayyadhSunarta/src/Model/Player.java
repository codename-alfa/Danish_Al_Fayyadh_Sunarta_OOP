package Model;
import java.util.UUID;
import java.time.LocalDateTime;

public class Player implements ShowDetail{
    private UUID playerId;
    private String username;
    private int highScore;
    private int totalCoins;
    private int totalDistance;
    private LocalDateTime createdAt;

    public Player(String username){
        this.playerId = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.username = username;
        this.highScore = 0;
        this.totalCoins = 0;
        this.totalDistance = 0;
    }

    public UUID getPlayerId(){
        return this.playerId;
    }

    public void updateHighScore(int newScore){
        if(newScore > this.highScore){
            this.highScore = newScore;
        }
    }

    public void addCoins(int coins){
        this.totalCoins += coins;
    }

    public void addDistance(int distance){
        this.totalDistance += distance;
    }

    public void showDetail(){
        System.out.println("Player ID : " + this.playerId);
        System.out.println("Username : " + this.username);
        System.out.println("High Score : " + this.highScore);
        System.out.println("Total coins : " + this.totalCoins);
        System.out.println("Total distance : " + this.totalDistance);
        System.out.println("Created at : " + this.createdAt);
        System.out.println();
    }
}
