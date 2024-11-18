package br.com.topper.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PlayerDataDTO {

    private List<StatisticsDTO> statistics;
}
