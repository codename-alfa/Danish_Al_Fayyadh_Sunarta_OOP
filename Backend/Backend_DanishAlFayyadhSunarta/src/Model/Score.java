package Model;
import java.util.UUID;
import java.time.LocalDateTime;

public class Score implements ShowDetail {
    private UUID scoreId;
    private UUID playerId;
    private Player player;
    private int value;
    private int coinsCollected;
    private int distance;
    private LocalDateTime createdAt;

    public Score(UUID playerId, int value, int coinsCollected, int distance){
        this.scoreId = UUID.randomUUID();
        this.playerId = playerId;
        this.value = value;
        this.coinsCollected = coinsCollected;
        this.distance = distance;
        this.createdAt = LocalDateTime.now();
    }

    public int getValue(){
        return  this.value;
    }

    public int getCoinsCollected(){
        return this.coinsCollected;
    }

    public int getDistance(){
        return this.distance;
    }

    public void showDetail(){
        System.out.println("Score ID : " + this.scoreId);
        System.out.println("Player : " + this.playerId);
        System.out.println("Score value : " + this.value);
        System.out.println("Coins collected : " + this.coinsCollected);
        System.out.println("Distance : " + this.distance);
        System.out.println("Created at : " + this.createdAt);
        System.out.println();
    }
}
