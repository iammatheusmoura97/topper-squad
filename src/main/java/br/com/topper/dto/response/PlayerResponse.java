package br.com.topper.dto.response;

import lombok.Data;

@Data
public class PlayerResponse {

    private String name;
    private String club;

    public PlayerResponse(String name) {
        this.name = name;
    }

    public PlayerResponse(String name, String club) {
        this.name = name;
        this.club = club;
    }



}
