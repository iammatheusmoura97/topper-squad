package br.com.topper.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Setter
@Data
@Builder
public class StatisticsAccumulatedDTO {

    private Integer totalGoals;
    private Integer totalAssists;

}
