package com.jgattringer.webServiceSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

// Indicates that this class is a JPA entity that will be mapped to a table in the database
@Entity
// Specifies the name of the table in the database
@Table(name = "tb_order")
public class Order implements Serializable {
    // Ensures version compatibility for serialization
    private static final long serialVersionUID = 1L;

    // Defines the id field as the primary key of the entity
    @Id
    // Configures the strategy for generating the primary key value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Represents the moment of the order
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    // Defines a many-to-one relationship with the User entity
    @ManyToOne
    // Specifies the foreign key column name in the database table
    @JoinColumn(name = "client_id")
    private User client;

    // Default constructor required by JPA
    public Order() {}

    // Constructor with all fields
    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    // Getter and setter methods for all fields
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

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    // Overrides the equals method to compare orders by their IDs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    // Overrides the hashCode method to generate a hash based on the ID
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
