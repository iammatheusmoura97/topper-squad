package br.com.topper.dto.response;

import br.com.topper.dto.PlayerDataDTO;
import lombok.Data;

@Data
public class PlayerResponse {

    private String name;
    private String club;
    private PlayerDataDTO data;

    public PlayerResponse(String name) {
        this.name = name;
    }

    public PlayerResponse(String name, String club, PlayerDataDTO data) {
        this.name = name;
        this.club = club;
        this.data = data;
    }



}
