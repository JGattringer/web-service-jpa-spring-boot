package com.jgattringer.webServiceSpringBoot.repositories;

import com.jgattringer.webServiceSpringBoot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository, which provides the basic CRUD operations for Product entities
public interface ProductRepository extends JpaRepository<Product, Long> {

}
