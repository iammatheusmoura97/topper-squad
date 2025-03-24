package br.com.topper.controller;

import br.com.topper.dto.StatisticsAccumulatedDTO;
import br.com.topper.dto.StatisticsDTO;
import br.com.topper.dto.request.StatisticsRequest;
import br.com.topper.service.impl.StatisticsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/admin/statistics")
public class StatisticsAdminController {

    private final StatisticsServiceImpl statisticsService;

    public StatisticsAdminController(StatisticsServiceImpl statisticsService) {
        this.statisticsService = statisticsService;
    }

    public ResponseEntity<Void> newStatistics(@RequestBody StatisticsRequest requestDto) {
        statisticsService.saveStatistics(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/admin/player/{id}")
                .buildAndExpand(requestDto.getPlayerId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PostMapping
    public ResponseEntity<Void> newStatisticsInMongo(@RequestBody StatisticsRequest requestDto) {
        statisticsService.saveStatistics(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/admin/player/{id}")
                .buildAndExpand(requestDto.getPlayerId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<List<StatisticsDTO>> getStatistics(@PathVariable("playerId") Long playerId) {
        return ResponseEntity.ok(statisticsService.getStatistics(playerId));
    }

    @GetMapping("/{playerId}/accumulated")
    public ResponseEntity<StatisticsAccumulatedDTO> getStatisticsAccumulated(@PathVariable("playerId") Long playerId) {
        return ResponseEntity.ok(statisticsService.getStatisticsAccumulated(playerId));
    }
}
