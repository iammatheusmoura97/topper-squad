package br.com.topper.service.impl;

import br.com.topper.dto.enuns.AttackPointsEnum;
import br.com.topper.dto.request.AttackStatisticsRequest;
import br.com.topper.dto.request.StatisticsRequest;
import br.com.topper.service.StatisticsCalculator;
import org.springframework.stereotype.Component;

@Component
public class AttackStatisticsCalculator implements StatisticsCalculator {

    @Override
    public Double calculate(StatisticsRequest requestDto) {
        AttackStatisticsRequest attackStatistics = requestDto.getAttackStatistics();

        Double goalPoints = attackStatistics.getGoal() * AttackPointsEnum.GOAL.getPoints();
        Double assistsPoints = attackStatistics.getAssist() * AttackPointsEnum.ASSIST.getPoints();
        Double missedPenaltyPoints = attackStatistics.getMissedPenalty() * AttackPointsEnum.MISSED_PENALTY.getPoints();

        return goalPoints + assistsPoints + missedPenaltyPoints;
    }
}
