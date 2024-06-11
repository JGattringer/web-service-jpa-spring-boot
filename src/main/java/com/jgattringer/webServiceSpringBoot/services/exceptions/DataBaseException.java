package com.jgattringer.webServiceSpringBoot.services.exceptions;

// Define uma exceção personalizada para erros relacionados ao banco de dados
public class DataBaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // Construtor que recebe uma mensagem de erro
    public DataBaseException(String msg) {
        // Chama o construtor da superclasse com a mensagem de erro fornecida
        super(msg);
    }
}
