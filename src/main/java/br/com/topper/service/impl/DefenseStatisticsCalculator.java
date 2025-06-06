package br.com.topper.service.impl;

import br.com.topper.dto.enuns.DefensePointsEnum;
import br.com.topper.dto.request.StatisticsRequest;
import br.com.topper.service.StatisticsCalculator;
import org.springframework.stereotype.Component;

@Component
public class DefenseStatisticsCalculator implements StatisticsCalculator {

    @Override
    public Double calculate(StatisticsRequest requestDto) {
        Double desarme = requestDto.getDefenseStatistics().getTackle() * DefensePointsEnum.DESARME.getPoints();
        Double saldoGols = requestDto.getDefenseStatistics().getGoalDifference() ? DefensePointsEnum.SALDO_GOLS.getPoints() : 0.0;
        Double faltaCometida = requestDto.getDefenseStatistics().getFoulCommitted() * DefensePointsEnum.FALTA_COMETIDA.getPoints();

        return desarme + saldoGols + faltaCometida;
    }
}
