package com.jgattringer.webServiceSpringBoot.resources;

import com.jgattringer.webServiceSpringBoot.entities.Product;
import com.jgattringer.webServiceSpringBoot.services.ProductService;
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
@RequestMapping(value = "/products")
public class ProducResource {

    // Injeta uma instância de ProductService automaticamente gerenciada pelo Spring
    @Autowired
    private ProductService service;

    // Mapeia a solicitação GET para "/products" para retornar todos os produtos
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        // Chama o serviço para encontrar todos os produtos
        List<Product> list = service.findAll();

        // Retorna uma resposta HTTP com a lista de produtos encontrados
        return ResponseEntity.ok().body(list);
    }

    // Mapeia a solicitação GET para "/products/{id}" para retornar um produto específico pelo ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        // Chama o serviço para encontrar o produto pelo ID especificado
        Product obj = service.findByI(id);

        // Retorna uma resposta HTTP com o produto encontrado
        return ResponseEntity.ok().body(obj);
    }
}

