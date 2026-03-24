package com.szdp.makeitnas.exception.payload;

import org.springframework.http.HttpStatus;

public record UserExceptionPayload(String message, HttpStatus status) {
    
}