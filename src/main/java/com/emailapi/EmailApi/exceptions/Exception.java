package com.emailapi.EmailApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Exception extends RuntimeException {

    public Exception (String message) {
        super(message);
    }

    public Exception (String message, Throwable cause) {
        super(message, cause);
    }
}
