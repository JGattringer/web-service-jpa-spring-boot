package com.jgattringer.webServiceSpringBoot.resources.exceptions;

import com.jgattringer.webServiceSpringBoot.services.exceptions.DataBaseException;
import com.jgattringer.webServiceSpringBoot.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

// Anotação para indicar que esta classe é um componente global que trata exceções em todos os controllers
@ControllerAdvice
public class ResourceExceptionHandler {

    // Método para tratar exceções do tipo ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found"; // Mensagem de erro para exceção
        HttpStatus status = HttpStatus.NOT_FOUND; // Status HTTP correspondente
        // Cria um objeto StandardError contendo detalhes sobre a exceção, incluindo a mensagem de erro, o código de status HTTP e a URI da solicitação
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        // Retorna uma resposta HTTP com o objeto StandardError e o status correspondente
        return ResponseEntity.status(status).body(err);
    }

    // Método para tratar exceções do tipo DataBaseException
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request) {
        String error = "Database error"; // Mensagem de erro para exceção
        HttpStatus status = HttpStatus.BAD_REQUEST; // Status HTTP correspondente
        // Cria um objeto StandardError contendo detalhes sobre a exceção, incluindo a mensagem de erro, o código de status HTTP e a URI da solicitação
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        // Retorna uma resposta HTTP com o objeto StandardError e o status correspondente
        return ResponseEntity.status(status).body(err);
    }
}
