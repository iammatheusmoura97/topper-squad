package br.com.topper.dto.entity;

import br.com.topper.dto.ScoutDTO;
import br.com.topper.dto.StatisticsDTO;
import br.com.topper.dto.request.AttackStatisticsRequest;
import br.com.topper.dto.request.DefenseStatisticsRequest;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "statistics")
@Getter
public class Statistics {

    @Id
    private String id;
    private Long playerId;
    private Integer round;
    private Boolean isPlayed;
    private ScoutDTO scout;

//    private String confronto;
//    private Rodada rodada;


    public Statistics() {}

    public Statistics(Long playerId,
                      Integer round,
                      Boolean isPlayed,
                      AttackStatisticsRequest attackStatisticsRequest,
                      DefenseStatisticsRequest defenseStatisticsRequest) {
        this.playerId = playerId;
        this.round = round;
        this.isPlayed = isPlayed;
        this.scout = new ScoutDTO(attackStatisticsRequest, defenseStatisticsRequest);
    }

    public List<StatisticsDTO> convertDataToStatisticsDTOList(List<Statistics> statisticsList) {
        return statisticsList.stream()
                .map(statistics -> new StatisticsDTO(statistics.getRound(),
                        statistics.getIsPlayed(),
                        new ScoutDTO(statistics.getScout().getAttack(), statistics.getScout().getDefense())))
                .collect(Collectors.toList());
    }
}
