package com.geral.rent.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.geral.rent.entities.Category;
import com.geral.rent.entities.Order;
import com.geral.rent.entities.Product;
import com.geral.rent.entities.User;
import com.geral.rent.repositories.CategoryRepository;
import com.geral.rent.repositories.OrderRepository;
import com.geral.rent.repositories.ProductRepository;
import com.geral.rent.repositories.UserRepository;
import com.rent.entities.enums.OrderStatus;

@Configuration
@Profile("test") // Somente acessa quando feito test
public class TestConfig implements CommandLineRunner { // Popular o banco de dados

	@Autowired // Como a framework Spring injeta a relação de dependência com princípio SOLID
	private UserRepository userRepository; // Injeção de dependência

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	/*@Autowired
	private PaymentRepository paymentRepository;*/
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Volkswagen");
		Category cat2 = new Category(null, "Ford");
		Category cat3 = new Category(null, "Chevrollet");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		Product p1 = new Product(1L, "Gol", "Volkswagen", 90.5, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T19:53:07Z"), "");
		Product p2 = new Product(1L, "Amarok", "Volkswagen", 250.0, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T19:53:07Z"), "");
		Product p3 = new Product(1L, "Onix", "Chevrolet", 60.5, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T19:53:07Z"), "");
		Product p4 = new Product(1L, "S10", "Chevrolet", 150.5, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T19:53:07Z"), "");
		Product p5 = new Product(1L, "Ranger", "Ford", 90.5, Instant.parse("2019-06-20T19:53:07Z"), Instant.parse("2019-06-20T19:53:07Z"), "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		
		User u1 = new User(null, "Maria ", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Pedro", "pedro@gmail.com", "977777777", "123456");
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAGO, u1); //u1 serve para instanciar os objetos user com order
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.AGUARDANDO_SER_PAGO, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.AGUARDANDO_SER_PAGO, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		/*Payment pay1 = new Payment(null, null, null, null, null, null);
		
		paymentRepository.saveAll(Arrays.asList(pay1));*/
	}

}

/*
 * Como fazer este método ser implementado na execução do projeto? Através da
 * implementação do commandLine Runner
 */