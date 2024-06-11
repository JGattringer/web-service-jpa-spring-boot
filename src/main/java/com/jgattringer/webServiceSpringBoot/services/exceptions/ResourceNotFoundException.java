package com.jgattringer.webServiceSpringBoot.services.exceptions;

// Define uma exceção personalizada para indicar que um recurso não foi encontrado
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // Construtor que recebe o ID do recurso não encontrado
    public ResourceNotFoundException(Object id) {
        // Chama o construtor da superclasse com uma mensagem de erro personalizada
        super("Resource not found. ID " + id);
    }
}
