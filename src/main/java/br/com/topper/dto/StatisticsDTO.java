package br.com.topper.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class StatisticsDTO {

    private Map<String, Long> attack;
    private Map<String, Object> defense;
}
