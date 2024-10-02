package br.com.topper.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerErrorResponse {

    private String message;
    private String namePlayer;
    private String teamName;
    private Long id;
}
