package com.rentx.utils;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseUtilsTest {

    /**
     * test case for the sender not found
     */
    @Test
    void sendNotFoundResponse() {
        String message = "Resource not found";
        ResponseEntity<Object> responseEntity = ResponseUtils.sendNotFoundResponse(message);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(message, responseEntity.getBody());
    }
}
