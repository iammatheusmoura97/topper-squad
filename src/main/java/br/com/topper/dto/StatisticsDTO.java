package br.com.topper.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StatisticsDTO {

    private Integer numRodada; // ToDo pelo numero da rodada, deverá puxar os dados da rodada pelo DB
    private Boolean isPlayed;
    private ScoutDTO scout;

    public StatisticsDTO(Integer numRodada, Boolean isPlayed, ScoutDTO scout) {
        this.numRodada = numRodada;
        this.isPlayed = isPlayed;
        this.scout = scout;
    }

}

