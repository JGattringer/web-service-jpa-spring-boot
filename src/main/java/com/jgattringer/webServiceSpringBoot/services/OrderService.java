package com.jgattringer.webServiceSpringBoot.services;

import com.jgattringer.webServiceSpringBoot.entities.Order;
import com.jgattringer.webServiceSpringBoot.repositories.OrderRepository;
import com.jgattringer.webServiceSpringBoot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotação para indicar que esta classe é um componente de serviço
@Service
public class OrderService {

    // Injeção de dependência do repositório de pedidos
    @Autowired
    private OrderRepository repository;

    // Método para buscar todos os pedidos
    public List<Order> findAll() {
        return repository.findAll();
    }

    // Método para buscar um pedido por ID
    public Order findByI(Long id) {
        // Busca o pedido pelo ID no repositório
        Optional<Order> obj = repository.findById(id);
        // Retorna o pedido, se presente, ou lança uma exceção se não encontrado
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
