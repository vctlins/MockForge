package br.com.mockforge.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotSupportedTypeException.class)
    public ResponseEntity<String> handleInvalidType(NotSupportedTypeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
