package br.com.topper.dto.enuns;

import lombok.Getter;

@Getter
public enum AttackPointsEnum {

    GOAL(8.0),
    ASSIST(5.0),
    MISSED_PENALTY(-4.0);

    private final Double points;

    AttackPointsEnum(Double points) {
        this.points = points;
    }

}
