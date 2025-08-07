package com.example.assess.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class ResponseGenerator {
    public static ResponseEntity<ApiResponse> successResponse(String message, Object data) {
        ApiResponse response = new ApiResponse("success", message, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static  ResponseEntity<ApiResponse> failureResponse(String message) {
        ApiResponse response = new ApiResponse("failure", message, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
