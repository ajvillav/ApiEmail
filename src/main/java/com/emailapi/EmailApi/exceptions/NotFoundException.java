package com.emailapi.EmailApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotFoundException {

    public ResponseEntity<?> Exception(String message) {
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
