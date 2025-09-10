import Model.Player;
import Model.Score;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Danish");
        Player player2 = new Player("Alfa");

        Score score1 = new Score(player1.getPlayerId(), 1500, 250, 5000);
        Score score2 = new Score(player2.getPlayerId(), 3200, 750, 12000);
        Score score3 = new Score(player1.getPlayerId(), 1800, 300, 6000);

        player1.updateHighScore(score1.getValue());
        player1.addCoins(score1.getCoinsCollected());
        player1.addDistance(score1.getDistance());

        player1.updateHighScore(score3.getValue());
        player1.addCoins(score3.getCoinsCollected());
        player1.addDistance(score3.getDistance());

        player2.updateHighScore(score2.getValue());
        player2.addCoins(score2.getCoinsCollected());
        player2.addDistance(score2.getDistance());

        player1.showDetail();
        player2.showDetail();
    }
}