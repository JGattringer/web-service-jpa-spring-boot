package com.jgattringer.webServiceSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Indica que esta classe é uma entidade JPA
@Entity
// Define o nome da tabela no banco de dados que esta entidade mapeia
@Table(name = "tb_category")
public class Category implements Serializable {
    // Número serial para garantir a compatibilidade durante a serialização
    private static final long serialVersionUID = 1L;

    // Define o campo 'id' como chave primária e sua estratégia de geração como IDENTITY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define o campo 'name' para armazenar o nome da categoria
    private String name;

    // Mapeia o relacionamento muitos-para-muitos com a entidade 'Product', sendo ignorado na serialização JSON
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    // Construtor padrão
    public Category(){
    }

    // Construtor com parâmetros
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Obtém o id da categoria
    public Long getId() {
        return id;
    }

    // Define o id da categoria
    public void setId(Long id) {
        this.id = id;
    }

    // Obtém o nome da categoria
    public String getName() {
        return name;
    }

    // Define o nome da categoria
    public void setName(String name) {
        this.name = name;
    }

    // Obtém o conjunto de produtos associados a esta categoria
    public Set<Product> getProducts() {
        return products;
    }

    // Verifica a igualdade entre dois objetos 'Category'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    // Gera um código hash para o objeto 'Category'
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
