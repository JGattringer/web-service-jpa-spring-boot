package com.jgattringer.webServiceSpringBoot.services;

import com.jgattringer.webServiceSpringBoot.entities.Category;
import com.jgattringer.webServiceSpringBoot.repositories.CategoryRepository;
import com.jgattringer.webServiceSpringBoot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotação para indicar que esta classe é um componente de serviço
@Service
public class CategoryService {

    // Injeção de dependência do repositório de categoria
    @Autowired
    private CategoryRepository repository;

    // Método para buscar todas as categorias
    public List<Category> findAll() {
        return repository.findAll();
    }

    // Método para buscar uma categoria por ID
    public Category findByI(Long id) {
        // Busca a categoria pelo ID no repositório
        Optional<Category> obj = repository.findById(id);
        // Retorna a categoria, se presente, ou lança uma exceção se não encontrada
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
