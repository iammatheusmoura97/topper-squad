package br.com.topper.service.impl;

import br.com.topper.dto.PlayerDTO;
import br.com.topper.dto.entity.Player;
import br.com.topper.dto.request.PlayerRequest;
import br.com.topper.exception.PlayerAlreadyExistsException;
import br.com.topper.exception.PlayerNotFoundException;
import br.com.topper.respository.PlayerRepository;
import br.com.topper.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
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
            return player.convertToDto(player);
        }).orElseThrow(() -> new PlayerNotFoundException("Jogador não encontrado", id));
    }

}
