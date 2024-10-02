package br.com.topper.service;

import br.com.topper.dto.PlayerDTO;
import br.com.topper.dto.request.PlayerRequest;

public interface PlayerService {

    PlayerDTO savePlayer(PlayerRequest requestDto);

    PlayerDTO getPlayer(Long id);

}
