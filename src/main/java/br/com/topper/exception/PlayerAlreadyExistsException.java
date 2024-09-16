package br.com.topper.exception;

import lombok.Getter;

@Getter
public class PlayerAlreadyExistsException extends RuntimeException {

    private String name;
    private String teamName;

    public PlayerAlreadyExistsException(String message) {
        super(message);
    }

    public PlayerAlreadyExistsException(String message, String name, String teamName) {
        super(message);
        this.name = name;
        this.teamName = teamName;
    }

}
