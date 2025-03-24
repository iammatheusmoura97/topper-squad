package br.com.topper.service.impl;

import br.com.topper.dto.PlayerDTO;
import br.com.topper.dto.StatisticsAccumulatedDTO;
import br.com.topper.dto.StatisticsDTO;
import br.com.topper.dto.entity.Player;
import br.com.topper.dto.request.PlayerRequest;
import br.com.topper.exception.PlayerAlreadyExistsException;
import br.com.topper.exception.PlayerNotFoundException;
import br.com.topper.mapper.StatisticsDTOMapper;
import br.com.topper.respository.PlayerRepository;
import br.com.topper.respository.StatisticsRepository;
import br.com.topper.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final StatisticsRepository statisticsRepository;
    private final StatisticsDTOMapper statisticsDTOMapper;


    public PlayerServiceImpl(PlayerRepository playerRepository, StatisticsRepository statisticsRepository, StatisticsDTOMapper statisticsDTOMapper) {
        this.playerRepository = playerRepository;
        this.statisticsRepository = statisticsRepository;
        this.statisticsDTOMapper = statisticsDTOMapper;
    }

    @Override
    public PlayerDTO savePlayer(PlayerRequest requestDto) {
        Player player = new Player(requestDto.getName(),
                requestDto.getClub(),
                requestDto.getPosition(),
                requestDto.getPrice(),
                requestDto.getStatus(),
                false);
        log.info("Salvando jogador: {}", player);
        playerRepository.findPlayerByNameAndClub(player.getName(), player.getClub()).ifPresentOrElse(
                p -> {
                    throw new PlayerAlreadyExistsException("Jogador já cadastrado", player.getName(), player.getClub());
                },
                () -> playerRepository.save(player));

        return player.convertToDto(player);
    }

    @Override
    public PlayerDTO getPlayer(Long id) {
        return playerRepository.findPlayerById(id).map(player -> {
            log.info("Jogador encontrado: {}", player);

            List<StatisticsDTO> statistics = statisticsRepository.findStatisticsByPlayerId(player.getId());
            StatisticsAccumulatedDTO statisticsAccumulated = statisticsRepository.findStatisticsAccumulated(player.getId())
                    .orElse(StatisticsAccumulatedDTO.builder()
                            .totalAssists(0)
                            .totalGoals(0)
                            .build());


            return player.convertToDto(player, statistics, statisticsAccumulated);
        }).orElseThrow(() -> new PlayerNotFoundException("Jogador não encontrado", id));
    }

}
