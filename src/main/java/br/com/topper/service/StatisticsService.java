package br.com.topper.service;

import br.com.topper.dto.request.StatisticsRequest;

public interface StatisticsService {

    Double saveStatistics(StatisticsRequest requestDto);
}
