
package com.draw.lots.exception;

import com.draw.lots.controller.dto.ErrorResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * GlobalControllerExceptionHandler
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ErrorResponse> constraintViolationException(Exception ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
        .message(ex.getMessage())
        .errCode("DUP")
        .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);

    }
    
}