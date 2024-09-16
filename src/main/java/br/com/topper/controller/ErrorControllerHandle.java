package br.com.topper.controller;

import br.com.topper.dto.response.PlayerErrorResponse;
import br.com.topper.exception.PlayerAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerHandle {

    @ExceptionHandler(PlayerAlreadyExistsException.class)
    public ResponseEntity<PlayerErrorResponse> handlePlayerAlreadyExistsException(PlayerAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                PlayerErrorResponse.builder()
                        .message(e.getMessage())
                        .namePlayer(e.getName())
                        .teamName(e.getTeamName())
                        .build());
    }


}
