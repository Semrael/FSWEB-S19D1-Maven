package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalErrorException {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleApiException(InvalidDataException invalidDataException){
        ExceptionResponse exceptionResponse=new ExceptionResponse(invalidDataException.getMessage(),invalidDataException.getHttpStatus().value(), LocalDateTime.now());
        log.error("InvalidDataException: {}", invalidDataException.getMessage());
        return new ResponseEntity<>(exceptionResponse, invalidDataException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleGlobalException(Exception ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                "An unexpected error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );
        log.error("Exception: {}", ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
