package com.curso.resources.exception;

import com.curso.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException err, HttpServletRequest req){
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        StandardError e = new StandardError(System.currentTimeMillis(), statusCode.value(),
                "Não encontrado", err.getMessage(), req.getRequestURI());
        return ResponseEntity.status(statusCode).body(e);
    }
}
