package br.com.topper.controller;

import br.com.topper.dto.request.StatisticsRequest;
import br.com.topper.service.impl.StatisticsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/admin/statistics")
public class StatisticsAdminController {

    private final StatisticsServiceImpl statisticsService;

    public StatisticsAdminController(StatisticsServiceImpl statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping
    public ResponseEntity<Void> newStatistics(@RequestBody StatisticsRequest requestDto) {
        statisticsService.saveStatistics(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/admin/player/{id}")
                .buildAndExpand(requestDto.getPlayerId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
