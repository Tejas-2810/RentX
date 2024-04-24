package com.rentx.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
    /**
     * static response entity send not found
     * @param message message
     * @return new response entity
     */
    public static ResponseEntity<Object> sendNotFoundResponse(String message) {
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
