package com.jgattringer.webServiceSpringBoot.services;

import com.jgattringer.webServiceSpringBoot.entities.Product;
import com.jgattringer.webServiceSpringBoot.repositories.ProductRepository;
import com.jgattringer.webServiceSpringBoot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotação para indicar que esta classe é um componente de serviço
@Service
public class ProductService {

    // Injeção de dependência do repositório de produtos
    @Autowired
    private ProductRepository repository;

    // Método para buscar todos os produtos
    public List<Product> findAll() {
        return repository.findAll();
    }

    // Método para buscar um produto por ID
    public Product findByI(Long id) {
        // Busca o produto pelo ID no repositório
        Optional<Product> obj = repository.findById(id);
        // Retorna o produto, se presente, ou lança uma exceção se não encontrado
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
