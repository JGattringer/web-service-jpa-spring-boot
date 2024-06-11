package com.jgattringer.webServiceSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jgattringer.webServiceSpringBoot.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

// Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
@Entity
// Especifica o nome da tabela no banco de dados
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    // Garante compatibilidade de versão para serialização
    private static final long serialVersionUID = 1L;

    // Chave primária composta para a entidade
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    // Campos para quantidade e preço do item do pedido
    private Integer quantity;
    private Double price;

    // Construtor padrão exigido pelo JPA
    public OrderItem() {
    }

    // Construtor com todos os campos
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    // Método para obter o pedido associado ao item do pedido, ignorado na serialização JSON para evitar referência cíclica
    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    // Método para definir o pedido associado ao item do pedido
    public void setOrder(Order order){
        id.setOrder(order);
    }

    // Método para obter o produto associado ao item do pedido
    public Product getProduct() {
        return id.getProduct();
    }

    // Método para definir o produto associado ao item do pedido
    public void setProduct(Product product){
        id.setProduct(product);
    }

    // Métodos getter e setter para quantidade e preço
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Método para calcular o subtotal do item do pedido
    public Double getSubtotal(){
        return price * quantity;
    }

    // Sobrescreve o método equals para comparar itens de pedido pela chave primária composta
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    // Sobrescreve o método hashCode para gerar um hash baseado na chave primária composta
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
