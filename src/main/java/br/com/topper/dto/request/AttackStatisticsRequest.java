package br.com.topper.dto.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AttackStatisticsRequest {

    private Long goal;
    private Long assist;
    private Long missedPenalty;
}
