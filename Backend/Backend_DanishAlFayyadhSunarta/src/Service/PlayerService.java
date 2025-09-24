package Service;

import Repository.PlayerRepository;
import Model.Player;
import java.util.*;

public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public boolean List<Player> existsByUsername(String username){
        return playerRepository.findByUsername(username).isPresent();
    }

    public List<Player> createPlayer(Player player){
        if existsByUsername(player.getUsername()){
            throw new RuntimeException();
        } else {
            playerRepository.save(Player player);
        }
    }

    public List<Player> getPlayerById(UUID playerId){

    }

    public List<Player> getPlayerByUsername(String username){

    }

    public List<Player> getAllPlayers(){

    }

    public List<Player> updatePlayer(UUID playerId, Player updatedPlayer){

    }

    public List<Player> deletePlayer(UUID playerId){

    }

    public List<Player> deletePlayerByUsername(String username){

    }

    public List<Player> updatePlayerStats(UUID playerId, int scoreValue, int coinsCollected, int distanceTravelled){

    }

    public List<Player> getLeaderboardByHighScore(int limit) {

    }

    public List<Player> getLeaderboardByTotalCoins(){

    }

    public List<Player> getLeaderboardByTotalDistance(){

    }

}
