package br.com.topper.dto.request;

import lombok.Getter;

@Getter
public class AttackStatisticsRequest {

    private Long goal;
    private Long assist;
    private Long missedPenalty;
}
