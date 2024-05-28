package com.jgattringer.webServiceSpringBoot.repositories;

import com.jgattringer.webServiceSpringBoot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository, which provides the basic CRUD operations for User entities
public interface UserRepository extends JpaRepository<User, Long> {

}
