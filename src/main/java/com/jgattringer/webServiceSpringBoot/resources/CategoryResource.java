package com.jgattringer.webServiceSpringBoot.resources;

import com.jgattringer.webServiceSpringBoot.entities.Category;
import com.jgattringer.webServiceSpringBoot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Define esta classe como um controlador REST
@RestController
// Define o mapeamento de URL base para todas as solicitações nesta classe
@RequestMapping(value = "/categories")
public class CategoryResource {

    // Injeta uma instância de CategoryService automaticamente gerenciada pelo Spring
    @Autowired
    private CategoryService service;

    // Mapeia a solicitação GET para "/categories" para retornar todas as categorias
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        // Chama o serviço para encontrar todas as categorias
        List<Category> list = service.findAll();

        // Retorna uma resposta HTTP com a lista de categorias encontradas
        return ResponseEntity.ok().body(list);
    }

    // Mapeia a solicitação GET para "/categories/{id}" para retornar uma categoria específica pelo ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        // Chama o serviço para encontrar a categoria pelo ID especificado
        Category obj = service.findByI(id);

        // Retorna uma resposta HTTP com a categoria encontrada
        return ResponseEntity.ok().body(obj);
    }
}
