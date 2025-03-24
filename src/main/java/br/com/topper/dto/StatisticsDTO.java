package br.com.topper.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class StatisticsDTO {

    private Long playerId;
    private Integer round; // ToDo pelo numero da rodada, deverá puxar os dados da rodada pelo DB
    private Boolean isPlayed;
    private ScoutDTO scout;

    public StatisticsDTO(Integer round, Boolean isPlayed, ScoutDTO scout) {
        this.round = round;
        this.isPlayed = isPlayed;
        this.scout = scout;
    }

}

