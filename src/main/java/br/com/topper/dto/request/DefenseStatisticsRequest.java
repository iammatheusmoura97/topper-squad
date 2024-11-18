package br.com.topper.dto.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DefenseStatisticsRequest {

    private Long tackle;
    private Boolean goalDifference;
    private Long foulCommitted;
}
