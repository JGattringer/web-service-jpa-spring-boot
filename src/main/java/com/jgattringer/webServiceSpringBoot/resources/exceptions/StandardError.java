package com.jgattringer.webServiceSpringBoot.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

// Classe que representa um objeto de erro padrão para ser retornado em respostas HTTP
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    // Timestamp para o momento em que o erro ocorreu, formatado como Instant
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp;

    // Código de status HTTP correspondente ao erro
    private Integer status;

    // Descrição do erro
    private String error;

    // Mensagem detalhada sobre o erro
    private String message;

    // Caminho URI da solicitação que causou o erro
    private String path;

    // Construtor vazio
    public StandardError() {

    }

    // Construtor com todos os campos
    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Métodos getter e setter para todos os campos

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
