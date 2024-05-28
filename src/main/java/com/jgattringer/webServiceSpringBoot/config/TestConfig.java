package com.jgattringer.webServiceSpringBoot.config;

import com.jgattringer.webServiceSpringBoot.entities.User;
import com.jgattringer.webServiceSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

// Indicates that this class is a Spring configuration class
@Configuration
// Specifies that this configuration is only active when the 'test' profile is active
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // Injects an instance of UserRepository automatically managed by Spring
    @Autowired
    private UserRepository userRepository;

    // This method is executed when the application starts
    @Override
    public void run(String... args) throws Exception {
        // Create two new users with sample data
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        // Save the users to the database using the repository
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
