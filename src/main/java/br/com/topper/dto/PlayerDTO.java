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

    public PlayerDTO(String name, String club, String position, Double price, String status, Boolean isBought) {
        this.name = name;
        this.club = club;
        this.position = position;
        this.price = price;
        this.status = status;
        this.isBought = isBought;
    }



}
