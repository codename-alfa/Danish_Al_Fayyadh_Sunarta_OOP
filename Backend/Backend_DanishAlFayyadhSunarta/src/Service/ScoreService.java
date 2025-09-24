package Service;

import Repository.ScoreRepository;
import Repository.PlayerRepository;
import Model.Score;
import java.util.*;

public class ScoreService {
    private ScoreRepository scoreRepository;
    private PlayerRepository playerRepository;
    private PlayerService playerService;

    public ScoreService(ScoreRepository scoreRepository, PlayerRepository playerRepository, PlayerService playerService){
        this.scoreRepository = scoreRepository;
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }

    public List<Score> createScore(Score score){

    }

    public List<Score> getScoreById(UUID scoreId){

    }

    public List<Score> getAllScores(){

    }

    public List<Score> getScoresByPlayerId(UUID playerId){

    }
    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId){

    }

    public List<Score> getLeaderboard(int limit){

    }

    public List<Score> getHighestScoreByPlayerId(UUID playerId){

    }

    public List<Score> getScoresAboveValue(int minValue){

    }

    public List<Score> getRecentScores(){

    }
    public List<Score> getTotalCoinsByPlayerId(UUID playerId){

    }

    public List<Score> getTotalDistanceByPlayerId(UUID playerId){

    }

    public List<Score> updateScore(UUID scoreId, Score updatedScore){

    }

    public List<Score> deleteScore(UUID scoreId){

    }

    public List<Score> deleteScoresByPlayerId(UUID playerId){

    }
}
