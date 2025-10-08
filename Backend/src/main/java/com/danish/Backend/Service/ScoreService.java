package com.danish.Backend.Service;

import com.danish.Backend.Model.Score;
import com.danish.Backend.Repository.PlayerRepository;
import com.danish.Backend.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @Transactional
    public Score createScore(Score score) {
        if (!playerRepository.existsById(score.getPlayerId())) {
            throw new RuntimeException("Player not found");
        }
        Score savedScore = scoreRepository.save(score);
        playerService.updatePlayerStats(
                savedScore.getPlayerId(),
                savedScore.getValue(),
                savedScore.getCoinsCollected(),
                savedScore.getDistanceTravelled()
        );
        return savedScore;
    }

    public Optional<Score> getScoreById(UUID scoreId) {
        return scoreRepository.findById(scoreId);
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public List<Score> getScoresByPlayerId(UUID playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }

    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return scoreRepository.findByPlayerIdOrderByValueDesc(playerId);
    }

    public List<Score> getLeaderboard(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return scoreRepository.findTopScores(pageable);
    }

    public Optional<Score> getHighestScoreByPlayerId(UUID playerId){
        List<Score> scores = scoreRepository.findHighestScoreByPlayerId(playerId);
        if(scores.isEmpty()){
            return Optional.empty();
        } else{
            return Optional.of(scores.get(0));
        }
    }

    public List<Score> getScoresAboveValue(Integer minValue){
        return scoreRepository.findByValueGreaterThan(minValue);
    }

    public  List<Score> getRecentScores(){
        return  scoreRepository.findAllByOrderByCreatedAtDesc();
    }

    public  Integer getTotalCoinsByPlayerId(UUID playerId ){
        Integer total = scoreRepository.getTotalCoinsByPlayerId(playerId);
        if(total == null){
            return 0;
        } else{
            return total;
        }
    }

    public Integer getTotalDistanceByPlayerId(UUID playerId){
        Integer total = scoreRepository.getTotalDistanceByPlayerId(playerId);
        if(total == null){
            return 0;
        } else{
            return total;
        }
    }

    public Score updateScore(UUID scoreId,  Score updatedScore){
        Optional<Score> score = scoreRepository.findById(scoreId);
            score.orElseThrow() -> new RuntimeException(...))
    }

    public Score deleteScore(UUID scoreId){

    }

    public Score deleteScoresByPlayerId(UUID playerId){

    }
}