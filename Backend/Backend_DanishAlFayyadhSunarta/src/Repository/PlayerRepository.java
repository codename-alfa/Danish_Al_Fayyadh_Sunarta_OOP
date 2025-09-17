package Repository;

import Model.Player;
import java.util.*;

public class PlayerRepository<Player, UUID> extends BaseRepository{
    public Optional<Player> findByUsername(String username){
        return allData.stream()
                .filter(player ->
                        player.getUsername().equals(username))
                .findFirst();
    }

    public Optional<Player> findTopPlayersByHighScore(int limit){

    }

    public Optional<Player> findByHighscoreGreaterThan(int minScore){

    }

    public Optional<Player> findAllByOrderByTotalCoinsDesc(){

    }

    public Optional<Player> findAllByOrderByTotalDistanceTravelledDesc(){

    }

    public Optional<Player> save(Player player){

    }

    public Optional<Player> getId(Player entity){

    }

}
