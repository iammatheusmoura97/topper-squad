package br.com.topper.service;

import br.com.topper.dto.StatisticsAccumulatedDTO;
import br.com.topper.dto.StatisticsDTO;
import br.com.topper.dto.request.StatisticsRequest;

import java.util.List;

public interface StatisticsService {

    void saveStatistics(StatisticsRequest requestDto);

    List<StatisticsDTO> getStatistics(Long playerId);

    StatisticsAccumulatedDTO getStatisticsAccumulated(Long playerId);
}
