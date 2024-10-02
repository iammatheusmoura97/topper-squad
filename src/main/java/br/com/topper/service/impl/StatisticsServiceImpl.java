package br.com.topper.service.impl;

import br.com.topper.dto.request.StatisticsRequest;
import br.com.topper.service.StatisticsService;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final AttackStatisticsCalculator attackStatisticsCalculator;
    private final DefenseStatisticsCalculator defenseStatisticsCalculator;

    public StatisticsServiceImpl(AttackStatisticsCalculator attackStatisticsCalculator,
                                 DefenseStatisticsCalculator defenseStatisticsCalculator) {
        this.attackStatisticsCalculator = attackStatisticsCalculator;
        this.defenseStatisticsCalculator = defenseStatisticsCalculator;
    }

    @Override
    public Double saveStatistics(StatisticsRequest requestDto) {
        Double attackStatistics = attackStatisticsCalculator.calculate(requestDto);
        Double defenseStatistics = defenseStatisticsCalculator.calculate(requestDto);
        double total = attackStatistics + defenseStatistics;

        total = requestDto.getRedCard() ? total - 5.0 : total;
        total = requestDto.getYellowCard() ? total - 2.0 : total;

        // todo - buscar jogador pelo id e salvar infos
        // todo - calcular infos general
        return total;
    }
}
