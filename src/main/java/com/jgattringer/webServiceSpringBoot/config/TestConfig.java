package com.jgattringer.webServiceSpringBoot.config;

import com.jgattringer.webServiceSpringBoot.entities.Category;
import com.jgattringer.webServiceSpringBoot.entities.Order;
import com.jgattringer.webServiceSpringBoot.entities.User;
import com.jgattringer.webServiceSpringBoot.entities.enums.OrderStatus;
import com.jgattringer.webServiceSpringBoot.repositories.CategoryRepository;
import com.jgattringer.webServiceSpringBoot.repositories.OrderRepository;
import com.jgattringer.webServiceSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

// Indicates that this class is a Spring configuration class
@Configuration
// Specifies that this configuration is only active when the 'test' profile is active
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // Injects an instance of UserRepository automatically managed by Spring
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // This method is executed when the application starts
    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // Create two new users with sample data
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.SHIPPED, u1);

        // Save the users to the database using the repository
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
