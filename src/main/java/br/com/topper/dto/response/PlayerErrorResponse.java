package br.com.topper.dto.response;

import lombok.*;

@Data
@Builder
public class PlayerErrorResponse {

    private String message;
    private String namePlayer;
    private String teamName;
}
