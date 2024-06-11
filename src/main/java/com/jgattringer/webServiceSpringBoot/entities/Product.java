package com.jgattringer.webServiceSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
@Entity
// Especifica o nome da tabela no banco de dados
@Table(name = "tb_product")
public class Product implements Serializable {
    // Garante compatibilidade de versão para serialização
    private static final long serialVersionUID = 1L;

    // Define o campo 'id' como chave primária da entidade
    @Id
    // Configura a estratégia para geração do valor da chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos para nome, descrição, preço e URL da imagem do produto
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    // Define um relacionamento muitos-para-muitos com a entidade 'Category'
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    // Define um relacionamento um-para-muitos com a entidade 'OrderItem'
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    // Construtor padrão exigido pelo JPA
    public Product() {
    }

    // Construtor com todos os campos
    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    // Método para obter os pedidos associados ao produto, ignorado na serialização JSON para evitar referência cíclica
    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();
        for (OrderItem x : items) {
            set.add(x.getOrder());
        }
        return set;
    }

    // Sobrescreve o método equals para comparar produtos pelos seus IDs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    // Sobrescreve o método hashCode para gerar um hash baseado no ID
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
