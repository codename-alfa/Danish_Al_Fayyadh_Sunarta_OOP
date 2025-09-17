package Repository;

import java.util.*;
import Model.Score;

public class ScoreRepository extends BaseRepository{
    public Optional<Score>findByPlayerId(UUID playerId){

    }

    public Optional<Score>findByPlayerIdOrderByValueDesc(UUID playerId){

    }

    public Optional<Score>findTopScores(int limit){

    }

    public Optional<Score>findHighestScoreByPlayerId(UUID playerId){

    }

    public Optional<Score>findByValueGreaterThan(Integer minValue){

    }

    public Optional<Score> findAllByOrderByCreatedAtDesc(){

    }

    public Optional<Score> getTotalCoinsByPlayerId(UUID playerId){

    }

    public Optional<Score> getTotalDistanceByPlayerId(UUID playerId){

    }

    public Optional<Score> save(Score score){

    }

    public Optional<Score> getId(Score entity){

    }

}
