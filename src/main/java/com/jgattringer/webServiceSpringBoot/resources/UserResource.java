package com.jgattringer.webServiceSpringBoot.resources;

import com.jgattringer.webServiceSpringBoot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "maria", "maria@gmail.com", "322425689", "123345" );
        return ResponseEntity.ok().body(u);
    }
}
