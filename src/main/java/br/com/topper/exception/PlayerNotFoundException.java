package br.com.topper.exception;

import lombok.Getter;

@Getter
public class PlayerNotFoundException extends RuntimeException {

    private Long id;

    public PlayerNotFoundException(String message) {
        super(message);
    }

    public PlayerNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }
}
