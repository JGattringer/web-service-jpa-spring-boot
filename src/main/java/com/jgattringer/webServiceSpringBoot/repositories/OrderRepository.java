package com.jgattringer.webServiceSpringBoot.repositories;

import com.jgattringer.webServiceSpringBoot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository, which provides the basic CRUD operations for Order entities
public interface OrderRepository extends JpaRepository<Order, Long> {

}
