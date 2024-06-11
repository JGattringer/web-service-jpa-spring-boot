package com.jgattringer.webServiceSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
@Entity
// Especifica o nome da tabela no banco de dados
@Table(name = "tb_user")
public class User implements Serializable {
    // UID de versão de serialização para garantir compatibilidade de versão
    private static final long serialVersionUID = 1L;

    // Chave primária da entidade
    @Id
    // Especifica a estratégia de geração para a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do usuário
    private String name;

    // E-mail do usuário
    private String email;

    // Número de telefone do usuário
    private String phone;

    // Senha do usuário
    private String password;

    // Lista de pedidos associados ao usuário, ignorada na serialização JSON para evitar referência cíclica
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    // Construtor vazio exigido por alguns frameworks
    public User() {
    }

    // Construtor com todos os campos
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Métodos getter e setter para todos os campos

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

    // Sobrescreve o método equals para comparar usuários pelos seus IDs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    // Sobrescreve o método hashCode para gerar um hash baseado no ID
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    // Sobrescreve o método toString para fornecer uma representação de string do objeto User
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
