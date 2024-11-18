package br.com.topper.dto;

import br.com.topper.dto.request.AttackStatisticsRequest;
import br.com.topper.dto.request.DefenseStatisticsRequest;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ScoutDTO {

    private AttackStatisticsRequest attack;
    private DefenseStatisticsRequest defense;

}
