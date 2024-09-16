package br.com.topper.dto.response;

import lombok.Data;

@Data
public class PlayerResponse {

    private String name;

    public PlayerResponse(String name) {
        this.name = name;
    }

}
