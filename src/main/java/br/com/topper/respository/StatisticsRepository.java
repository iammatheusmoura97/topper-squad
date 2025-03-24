package br.com.topper.respository;

import br.com.topper.dto.StatisticsAccumulatedDTO;
import br.com.topper.dto.StatisticsDTO;
import br.com.topper.dto.entity.Statistics;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StatisticsRepository extends MongoRepository<Statistics, String> {

    List<StatisticsDTO> findStatisticsByPlayerId(Long playerId);

    @Aggregation(pipeline = {
            "{ $match: { 'playerId': ?0 } }",
            "{ $group: { '_id': '$playerId', " +
                    "'totalGoals': { $sum: '$scout.attack.goal' }, " +
                    "'totalAssists': { $sum: '$scout.attack.assist' } } }"
    })
    Optional<StatisticsAccumulatedDTO> findStatisticsAccumulated(Long playerId);


}
