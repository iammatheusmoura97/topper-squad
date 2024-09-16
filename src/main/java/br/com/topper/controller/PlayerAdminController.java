package br.com.topper.controller;

import br.com.topper.dto.request.PlayerRequest;
import br.com.topper.dto.response.PlayerResponse;
import br.com.topper.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/player")
public class PlayerAdminController {

    private final PlayerService playerService;

    public PlayerAdminController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerResponse> newPlayer(@RequestBody PlayerRequest playerRequest) {
        playerService.savePlayer(playerRequest);

        return ResponseEntity.ok(new PlayerResponse(playerRequest.getName()));
    }


}
