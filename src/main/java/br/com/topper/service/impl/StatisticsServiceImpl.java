package br.com.topper.service.impl;

import br.com.topper.dto.StatisticsDTO;
import br.com.topper.dto.entity.Player;
import br.com.topper.dto.entity.PlayerData;
import br.com.topper.dto.request.StatisticsRequest;
import br.com.topper.exception.PlayerNotFoundException;
import br.com.topper.respository.PlayerDataRepository;
import br.com.topper.respository.PlayerRepository;
import br.com.topper.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

    private final AttackStatisticsCalculator attackStatisticsCalculator;
    private final DefenseStatisticsCalculator defenseStatisticsCalculator;
    private final PlayerRepository playerRepository;
    private final PlayerDataRepository playerDataRepository;


    public StatisticsServiceImpl(AttackStatisticsCalculator attackStatisticsCalculator,
                                 DefenseStatisticsCalculator defenseStatisticsCalculator,
                                 PlayerRepository playerRepository,
                                 PlayerDataRepository playerDataRepository) {
        this.attackStatisticsCalculator = attackStatisticsCalculator;
        this.defenseStatisticsCalculator = defenseStatisticsCalculator;
        this.playerRepository = playerRepository;
        this.playerDataRepository = playerDataRepository;
    }

    @Override
    public Double saveStatistics(StatisticsRequest requestDto) {
        // Todo - Ao salvar uma nova estatistica, devera acumular com a existente. Associar a rodada do campeonato com a estatistica;
        StatisticsDTO statisticsDTO = new StatisticsDTO();

        Map<String, Long> attackStatistics = Map.of(
                "goal", requestDto.getAttackStatistics().getGoal(),
                "assist", requestDto.getAttackStatistics().getAssist(),
                "missedPenalty", requestDto.getAttackStatistics().getMissedPenalty()
        );

        Map<String, Object> defenseStatistics = Map.of(
                "tackle", requestDto.getDefenseStatistics().getTackle(),
                "foulCommitted", requestDto.getDefenseStatistics().getFoulCommitted(),
                "goalDifference", requestDto.getDefenseStatistics().getGoalDifference()
        );

        statisticsDTO.setAttack(attackStatistics);
        statisticsDTO.setDefense(defenseStatistics);

        Player player = playerRepository.findPlayerById(requestDto.getPlayerId()).
                orElseThrow(() -> new PlayerNotFoundException("Jogador não encontrado", requestDto.getPlayerId()));

        log.info("Jogador encontrado: {}", player);

        PlayerData playerData = new PlayerData(player, statisticsDTO);
        playerDataRepository.save(playerData);

        return calculatePoints(requestDto);
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
