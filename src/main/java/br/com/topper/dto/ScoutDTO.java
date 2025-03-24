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

    public ScoutDTO() {
    }

    public ScoutDTO(AttackStatisticsRequest attack, DefenseStatisticsRequest defense) {
        this.attack = attack;
        this.defense = defense;
    }
}
