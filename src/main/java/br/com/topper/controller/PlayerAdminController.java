package br.com.topper.controller;

import br.com.topper.dto.PlayerDTO;
import br.com.topper.dto.request.PlayerRequest;
import br.com.topper.dto.response.PlayerResponse;
import br.com.topper.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/player")
public class PlayerAdminController {

    private final PlayerService playerService;

    public PlayerAdminController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerResponse> newPlayer(@RequestBody PlayerRequest playerRequest) {
        PlayerDTO playerDTO = playerService.savePlayer(playerRequest);

        return ResponseEntity.ok(new PlayerResponse(playerDTO.getName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponse> getPlayer(@PathVariable("id") Long id) {
        PlayerDTO player = playerService.getPlayer(id);

        return ResponseEntity.ok(new PlayerResponse(player.getName(), player.getClub(), player.getPlayerData()));
    }


}
