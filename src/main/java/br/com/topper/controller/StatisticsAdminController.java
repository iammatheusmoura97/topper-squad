package br.com.topper.controller;

import br.com.topper.dto.request.StatisticsRequest;
import br.com.topper.service.impl.StatisticsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/statistics")
public class StatisticsAdminController {

    private final StatisticsServiceImpl statisticsService;

    public StatisticsAdminController(StatisticsServiceImpl statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping
    public ResponseEntity<Double> newStatistics(@RequestBody StatisticsRequest requestDto) {
        Double totalPoints = statisticsService.saveStatistics(requestDto);

        return ResponseEntity.ok(totalPoints);
    }
}
