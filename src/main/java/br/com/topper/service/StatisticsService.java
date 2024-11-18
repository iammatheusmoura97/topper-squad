package br.com.topper.service;

import br.com.topper.dto.request.StatisticsRequest;

public interface StatisticsService {
    void saveStatistics(StatisticsRequest requestDto);
}
