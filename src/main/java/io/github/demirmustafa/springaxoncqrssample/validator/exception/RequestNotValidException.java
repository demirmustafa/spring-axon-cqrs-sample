package io.github.demirmustafa.springaxoncqrssample.validator.exception;

import lombok.Getter;

@Getter
public class RequestNotValidException extends RuntimeException {

    private String message;

    public RequestNotValidException(String message) {
        super(message);
        this.message = message;
    }
}
