package br.com.topper.mapper;

import br.com.topper.dto.ScoutDTO;
import br.com.topper.dto.StatisticsDTO;
import br.com.topper.dto.entity.Statistics;
import br.com.topper.dto.request.StatisticsRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatisticsDTOMapper {

    public StatisticsDTO createStatisticsDTO(StatisticsRequest requestDto) {
        ScoutDTO scout = new ScoutDTO();
        scout.setAttack(requestDto.getAttackStatistics());
        scout.setDefense(requestDto.getDefenseStatistics());

        return new StatisticsDTO(requestDto.getRound(), requestDto.getIsPlayed(), scout);
    }

    public Statistics createStatistics(StatisticsRequest requestDto) {
        return new Statistics(requestDto.getPlayerId(),
                requestDto.getRound(),
                requestDto.getIsPlayed(),
                requestDto.getAttackStatistics(),
                requestDto.getDefenseStatistics());
    }

    public List<StatisticsDTO> createStatisticsDTOList(List<Statistics> statisticsList) {
        return statisticsList.stream()
                .map(statistics -> new StatisticsDTO(statistics.getRound(),
                        statistics.getIsPlayed(),
                        new ScoutDTO(statistics.getScout().getAttack(), statistics.getScout().getDefense())))
                .collect(Collectors.toList());
    }
}
