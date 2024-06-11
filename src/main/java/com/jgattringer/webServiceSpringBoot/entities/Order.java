package com.jgattringer.webServiceSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jgattringer.webServiceSpringBoot.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
@Entity
// Especifica o nome da tabela no banco de dados
@Table(name = "tb_order")
public class Order implements Serializable {
    // Garante compatibilidade de versão para serialização
    private static final long serialVersionUID = 1L;

    // Define o campo 'id' como chave primária da entidade
    @Id
    // Configura a estratégia para geração do valor da chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Representa o momento do pedido
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    // Representa o status do pedido como um inteiro
    private Integer orderStatus;

    // Define um relacionamento muitos-para-um com a entidade 'User'
    @ManyToOne
    // Especifica o nome da coluna de chave estrangeira na tabela do banco de dados
    @JoinColumn(name = "client_id")
    private User client;

    // Define um relacionamento um-para-muitos com a entidade 'OrderItem'
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    // Define um relacionamento um-para-um com a entidade 'Payment'
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    // Construtor padrão exigido pelo JPA
    public Order() {}

    // Construtor com todos os campos
    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    // Obtém o pagamento associado ao pedido
    public Payment getPayment() {
        return payment;
    }

    // Define o pagamento associado ao pedido
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    // Obtém o conjunto de itens de pedido associados a este pedido
    public Set<OrderItem> getItems() {
        return items;
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

    // Obtém o status do pedido
    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }

    // Define o status do pedido
    public void setOrderStatus(OrderStatus orderStatus){
        if(orderStatus  != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    // Calcula o total do pedido somando os subtotais dos itens do pedido
    public Double getTotal(){
        double sum = 0.0;
        for (OrderItem x : items){
            sum += x.getSubtotal();
        }
        return sum;
    }

    // Sobrescreve o método equals para comparar pedidos pelos seus IDs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    // Sobrescreve o método hashCode para gerar um hash baseado no ID
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
