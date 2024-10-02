package br.com.topper.service;

import br.com.topper.dto.request.StatisticsRequest;

public interface StatisticsCalculator {

    Double calculate(StatisticsRequest requestDto);

}
