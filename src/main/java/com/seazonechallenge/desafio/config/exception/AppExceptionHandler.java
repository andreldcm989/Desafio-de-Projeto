package com.seazonechallenge.desafio.config.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.seazonechallenge.desafio.service.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ModeloException> montarRespostaException(ResourceNotFoundException exception,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ModeloException erro = new ModeloException(Instant.now(), status.value(), "Not Found", exception.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }
}
