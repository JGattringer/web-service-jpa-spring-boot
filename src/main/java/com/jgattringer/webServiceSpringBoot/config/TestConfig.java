package com.jgattringer.webServiceSpringBoot.config;

import com.jgattringer.webServiceSpringBoot.entities.*;
import com.jgattringer.webServiceSpringBoot.entities.enums.OrderStatus;
import com.jgattringer.webServiceSpringBoot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

// Indica que esta classe é uma classe de configuração do Spring
@Configuration
// Especifica que esta configuração é ativa apenas quando o perfil 'test' está ativo
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // Injeta uma instância de UserRepository gerenciada automaticamente pelo Spring
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    // Este método é executado quando a aplicação inicia
    @Override
    public void run(String... args) throws Exception {

        // Cria categorias de exemplo
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        // Cria produtos de exemplo
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        // Salva as categorias no banco de dados
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        // Salva os produtos no banco de dados
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Associa os produtos às categorias correspondentes
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        // Atualiza os produtos no banco de dados com as novas associações
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Cria dois novos usuários com dados de exemplo
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        // Cria pedidos de exemplo associados aos usuários
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);

        // Salva os usuários no banco de dados usando o repositório
        userRepository.saveAll(Arrays.asList(u1, u2));
        // Salva os pedidos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        // Cria itens de pedido associados aos pedidos e produtos
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        // Salva os itens de pedido no banco de dados
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        // Cria um pagamento associado a um dos pedidos
        Payment pay1 = new Payment(null,Instant.parse("2019-06-20T21:53:07Z"), o1 );
        o1.setPayment(pay1);
        // Atualiza o pedido no banco de dados com o pagamento associado
        orderRepository.save(o1);
    }
}
