package com.geral.rent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geral.rent.entities.Order;
import com.geral.rent.repositories.OrderRepository;

@Service 
public class OrderService {

	@Autowired //O Spring faz a injeção de forma automática e trasnparente
	private OrderRepository repository; //Injeção de dependência com a interface

	public List<Order> findAll(){
		return repository.findAll(); //Chamando a lista para encontrar o serviço de repositório na Arquiterura do projeto
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}

//@Service Registra a classe como componente do spring, da mesma forma que o @Component, porém com uma semântica mais específica