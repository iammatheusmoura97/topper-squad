package br.com.topper.controller;

import br.com.topper.dto.response.PlayerErrorResponse;
import br.com.topper.exception.PlayerAlreadyExistsException;
import br.com.topper.exception.PlayerNotFoundException;
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

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<PlayerErrorResponse> handlePlayerNotFoundException(PlayerNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                PlayerErrorResponse.builder()
                        .message(e.getMessage())
                        .id(e.getId())
                        .build());
    }


}
