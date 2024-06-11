package com.jgattringer.webServiceSpringBoot.resources;

import com.jgattringer.webServiceSpringBoot.entities.Order;
import com.jgattringer.webServiceSpringBoot.services.OrderService;
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
@RequestMapping(value = "/orders")
public class OrderResource {

    // Injeta uma instância de OrderService automaticamente gerenciada pelo Spring
    @Autowired
    private OrderService service;

    // Mapeia a solicitação GET para "/orders" para retornar todos os pedidos
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        // Chama o serviço para encontrar todos os pedidos
        List<Order> list = service.findAll();

        // Retorna uma resposta HTTP com a lista de pedidos encontrados
        return ResponseEntity.ok().body(list);
    }

    // Mapeia a solicitação GET para "/orders/{id}" para retornar um pedido específico pelo ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        // Chama o serviço para encontrar o pedido pelo ID especificado
        Order obj = service.findByI(id);

        // Retorna uma resposta HTTP com o pedido encontrado
        return ResponseEntity.ok().body(obj);
    }
}
