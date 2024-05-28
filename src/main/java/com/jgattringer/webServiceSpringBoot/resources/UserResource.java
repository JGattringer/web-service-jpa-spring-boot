package com.jgattringer.webServiceSpringBoot.resources;

import com.jgattringer.webServiceSpringBoot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Indicates that this class is a REST controller
@RestController
// Defines the base URL path for all endpoints in this controller
@RequestMapping(value = "/users")
public class UserResource {

    // Defines a GET endpoint to retrieve all users
    @GetMapping
    public ResponseEntity<User> findAll() {
        // Create a sample User object (for demonstration purposes)
        User u = new User(1L, "maria", "maria@gmail.com", "322425689", "123345" );
        // Return HTTP 200 OK response with the User object in the body
        return ResponseEntity.ok().body(u);
    }
}
