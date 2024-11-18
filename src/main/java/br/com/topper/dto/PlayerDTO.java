package br.com.topper.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerDTO {

    private String name;
    private String club;
    private String position;
    private Double price;
    private String status;
    private Boolean isBought;
    private PlayerDataDTO playerData;

}
