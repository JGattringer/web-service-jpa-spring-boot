package com.jgattringer.webServiceSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Indicates that this class is an entity mapped to a database table
@Entity
// Specifies the name of the database table
@Table(name = "tb_user")
public class User implements Serializable {
    // Serialization version UID to ensure version compatibility
    private static final long serialVersionUID = 1L;

    // Primary key of the entity
    @Id
    // Specifies the generation strategy for the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User's name
    private String name;

    // User's email
    private String email;

    // User's phone number
    private String phone;

    // User's password
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    // Empty constructor required by some frameworks
    public User() {
    }

    // Constructor with all fields
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Getter and Setter methods for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }
    // Overrides equals method to compare users by their IDs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    // Overrides hashCode method to generate hash based on ID
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    // Overrides toString method to provide a string representation of the User object
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
