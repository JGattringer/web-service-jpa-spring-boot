package com.jgattringer.webServiceSpringBoot.repositories;

import com.jgattringer.webServiceSpringBoot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interface estende JpaRepository, que fornece operações CRUD básicas para entidades de Categoria
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
