package com.geral.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geral.projeto.entities.Product;
import com.geral.projeto.repositories.ProductRepository;

@Service 
public class ProductService {

	@Autowired //O Spring faz a injeção de forma automática e trasnparente
	private ProductRepository repository; //Injeção de dependência com a interface

	public List<Product> findAll(){
		return repository.findAll(); //Chamando a lista para encontrar o serviço de repositório na Arquiterura do projeto
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}

//@Service Registra a classe como componente do spring, da mesma forma que o @Component, porém com uma semântica mais específica