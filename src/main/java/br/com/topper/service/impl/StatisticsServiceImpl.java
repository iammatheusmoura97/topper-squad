package br.com.topper.service.impl;

import br.com.topper.dto.StatisticsAccumulatedDTO;
import br.com.topper.dto.StatisticsDTO;
import br.com.topper.dto.entity.Player;
import br.com.topper.dto.entity.Statistics;
import br.com.topper.dto.request.StatisticsRequest;
import br.com.topper.exception.PlayerNotFoundException;
import br.com.topper.mapper.StatisticsDTOMapper;
import br.com.topper.respository.PlayerRepository;
import br.com.topper.respository.StatisticsRepository;
import br.com.topper.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

    private final AttackStatisticsCalculator attackStatisticsCalculator;
    private final DefenseStatisticsCalculator defenseStatisticsCalculator;
    private final PlayerRepository playerRepository;
    private final StatisticsDTOMapper statisticsDTOMapper;
    private final StatisticsRepository statisticsRepository;

    public StatisticsServiceImpl(AttackStatisticsCalculator attackStatisticsCalculator,
                                 DefenseStatisticsCalculator defenseStatisticsCalculator,
                                 PlayerRepository playerRepository,
                                 StatisticsDTOMapper statisticsDTOMapper,
                                 StatisticsRepository statisticsRepository) {
        this.attackStatisticsCalculator = attackStatisticsCalculator;
        this.defenseStatisticsCalculator = defenseStatisticsCalculator;
        this.playerRepository = playerRepository;
        this.statisticsDTOMapper = statisticsDTOMapper;
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public void saveStatistics(StatisticsRequest requestDto) {
        // validando se o jogador existe na base
        Player player = playerRepository.findPlayerById(requestDto.getPlayerId())
                .orElseThrow(() -> new PlayerNotFoundException("Jogador não encontrado", requestDto.getPlayerId()));

        // validar se o jogador for atacante, se for ATA! Não calcula pontos de SG
        if (player.getPosition().equals("MEI") || player.getPosition().equals("ATA")) {
            requestDto.getDefenseStatistics().setGoalDifference(false);
        }

        Statistics statistics = statisticsDTOMapper.createStatistics(requestDto);
        log.debug("saveStatisticsInMongo() - statistics: {}", statistics);

        statisticsRepository.save(statistics);
    }

    @Override
    public List<StatisticsDTO> getStatistics(Long playerId) {
        return statisticsRepository.findStatisticsByPlayerId(playerId);
    }

    @Override
    public StatisticsAccumulatedDTO getStatisticsAccumulated(Long playerId) {
        return statisticsRepository.findStatisticsAccumulated(playerId)
                .orElse(StatisticsAccumulatedDTO.builder()
                        .totalAssists(0)
                        .totalGoals(0)
                        .build());
    }

    private double calculatePoints(StatisticsRequest requestDto) {
        // Calculo dos pontos
        Double attackPoints = attackStatisticsCalculator.calculate(requestDto);
        Double defensePoints = defenseStatisticsCalculator.calculate(requestDto);

        double total = attackPoints + defensePoints;

        total = requestDto.getRedCard() ? total - 5.0 : total;
        total = requestDto.getYellowCard() ? total - 2.0 : total;


        // todo - buscar jogador pelo id e salvar infos
        // todo - calcular infos general
        return total;
    }
}
