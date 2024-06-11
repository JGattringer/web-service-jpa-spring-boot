package com.jgattringer.webServiceSpringBoot.entities.enums;

// Enumeração que representa o status de um pedido
public enum OrderStatus {
    WAITING_PAYMENT(1),  // Aguardando pagamento
    PAID(2),             // Pago
    SHIPPED(3),          // Enviado
    DELIVERED(4),        // Entregue
    CANCELED(5);         // Cancelado

    // Código numérico associado a cada status de pedido
    private int code;

    // Construtor privado que associa um código a cada constante de enumeração
    private OrderStatus(int code) {
        this.code = code;
    }

    // Método que retorna o código associado ao status do pedido
    public int getCode() {
        return code;
    }

    // Método estático que retorna o status do pedido correspondente a um código dado
    public static OrderStatus valueOf(int code) {
        // Percorre todos os valores do enum
        for (OrderStatus value : OrderStatus.values()) {
            // Retorna o valor do enum correspondente ao código fornecido
            if(value.getCode() == code) {
                return value;
            }
        }
        // Lança uma exceção se o código não for válido
        throw new IllegalArgumentException("Invalid OrderStatus Code!");
    }
}
