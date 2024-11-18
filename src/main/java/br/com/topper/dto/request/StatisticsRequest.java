package br.com.topper.dto.request;

import lombok.Getter;

@Getter
public class StatisticsRequest {

    private Long playerId;
    private Integer numRodada;
    private Boolean isPlayed;

    private AttackStatisticsRequest attackStatistics;
    private DefenseStatisticsRequest defenseStatistics;
    private Boolean yellowCard;
    private Boolean redCard;

}
