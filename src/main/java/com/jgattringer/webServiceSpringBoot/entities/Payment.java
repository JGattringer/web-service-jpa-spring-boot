package com.jgattringer.webServiceSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

// Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
@Entity
// Especifica o nome da tabela no banco de dados
@Table(name = "tb_payment")
public class Payment implements Serializable {
    // Garante compatibilidade de versão para serialização
    private static final long serialVersionUID = 1L;

    // Define o campo 'id' como chave primária da entidade
    @Id
    // Configura a estratégia para geração do valor da chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Representa o momento do pagamento
    private Instant moment;

    // Define um relacionamento um-para-um com a entidade 'Order', ignorado na serialização JSON para evitar referência cíclica
    @JsonIgnore
    @OneToOne
    // Anota a coluna de chave estrangeira e mapeia a chave primária do 'Payment' com a do 'Order'
    @MapsId
    private Order order;

    // Construtor padrão exigido pelo JPA
    public Payment() {
    }

    // Construtor com todos os campos
    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    // Métodos getter e setter para todos os campos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // Sobrescreve o método equals para comparar pagamentos pelos seus IDs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    // Sobrescreve o método hashCode para gerar um hash baseado no ID
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

