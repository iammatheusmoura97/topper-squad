package br.com.topper.service.impl;

import br.com.topper.dto.entity.Player;
import br.com.topper.dto.request.PlayerRequest;
import br.com.topper.exception.PlayerAlreadyExistsException;
import br.com.topper.respository.PlayerRepository;
import br.com.topper.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void savePlayer(PlayerRequest requestDto) {
        Player player = new Player(requestDto.getName(),
                requestDto.getClub(),
                requestDto.getPosition(),
                requestDto.getPrice(),
                requestDto.getStatus(),
                false);

        playerRepository.findPlayerByNameAndClub(player.getName(), player.getClub()).ifPresentOrElse(
                p -> {
                    throw new PlayerAlreadyExistsException("Jogador já cadastrado", player.getName(), player.getClub());
                },
                () -> playerRepository.save(player));
    }

}
