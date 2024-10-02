package br.com.topper.dto.request;

import lombok.Getter;

@Getter
public class DefenseStatisticsRequest {

    private Long desarme;
    private Boolean saldoGols;
    private Long faltaCometida;
}
