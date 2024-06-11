package com.jgattringer.webServiceSpringBoot.entities.pk;

import com.jgattringer.webServiceSpringBoot.entities.Order;
import com.jgattringer.webServiceSpringBoot.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

// Indica que esta classe é um tipo embutível que pode ser usado como parte de outra entidade
@Embeddable
public class OrderItemPK implements Serializable {
    // Número serial para garantir a compatibilidade durante a serialização
    private static final long serialVersionUID = 1L;

    // Muitos itens de pedido podem estar associados a um produto
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Muitos itens de pedido podem estar associados a um pedido
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Obtém o produto associado ao item do pedido
    public Product getProduct() {
        return product;
    }

    // Define o produto associado ao item do pedido
    public void setProduct(Product product) {
        this.product = product;
    }

    // Obtém o pedido associado ao item do pedido
    public Order getOrder() {
        return order;
    }

    // Define o pedido associado ao item do pedido
    public void setOrder(Order order) {
        this.order = order;
    }

    // Verifica a igualdade entre dois objetos OrderItemPK
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(product, that.product) && Objects.equals(order, that.order);
    }

    // Gera um código hash para o objeto OrderItemPK
    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }
}
