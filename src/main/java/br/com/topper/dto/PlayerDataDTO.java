package br.com.topper.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerDataDTO {

    private StatisticsDTO statistics;
}
