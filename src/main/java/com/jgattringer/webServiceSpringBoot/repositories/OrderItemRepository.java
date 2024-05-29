package com.jgattringer.webServiceSpringBoot.repositories;

import com.jgattringer.webServiceSpringBoot.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository, which provides the basic CRUD operations for OrderItem entities
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
