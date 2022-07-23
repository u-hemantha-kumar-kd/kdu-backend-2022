package com.kd.backend.springboot.controller;

import com.kd.backend.springboot.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDTO> handleNullPointerExceptions() {
        return new ResponseEntity<ErrorDTO>(
                new ErrorDTO("NULL_VALUE", "Something not null was null"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
