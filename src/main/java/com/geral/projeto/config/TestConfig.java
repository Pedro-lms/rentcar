package com.geral.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.geral.projeto.entities.Category;
import com.geral.projeto.entities.Order;
import com.geral.projeto.entities.OrderStatus;
import com.geral.projeto.entities.User;
import com.geral.projeto.repositories.CategoryRepository;
import com.geral.projeto.repositories.OrderRepository;
import com.geral.projeto.repositories.UserRepository;

@Configuration
@Profile("test") // Somente acessa quando feito test
public class TestConfig implements CommandLineRunner { // Popular o banco de dados

	@Autowired // Como a framework Spring injeta a relação de dependência com princípio SOLID
	private UserRepository userRepository; // Injeção de dependência

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); //u1 serve para instanciar os objetos user com order
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}

/*
 * Como fazer este método ser implementado na execução do projeto? Através da
 * implementação do commandLine Runner
 */