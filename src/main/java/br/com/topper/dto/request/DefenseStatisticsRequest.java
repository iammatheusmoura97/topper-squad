package br.com.topper.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class DefenseStatisticsRequest {

    private Long tackle;
    private Long foulCommitted;

    @Setter
    private Boolean goalDifference;

}
