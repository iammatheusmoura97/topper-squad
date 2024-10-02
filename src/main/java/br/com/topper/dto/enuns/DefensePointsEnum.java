package br.com.topper.dto.enuns;

import lombok.Getter;

@Getter
public enum DefensePointsEnum {

    DESARME(1.2),
    SALDO_GOLS(5.0),
    FALTA_COMETIDA(-0.3);

    private final Double points;

    DefensePointsEnum(Double points) {
        this.points = points;
    }
}
