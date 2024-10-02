package br.com.topper.dto.request;

import lombok.Getter;

@Getter
public class StatisticsRequest {

    private Long playerId;
    private AttackStatisticsRequest attackStatistics;
    private DefenseStatisticsRequest defenseStatistics;
    private Boolean yellowCard;
    private Boolean redCard;

}