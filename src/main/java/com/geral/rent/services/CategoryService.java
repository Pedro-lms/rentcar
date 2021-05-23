package com.geral.rent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geral.rent.entities.Category;
import com.geral.rent.repositories.CategoryRepository;

@Service 
public class CategoryService {

	@Autowired //O Spring faz a injeção de forma automática e trasnparente
	private CategoryRepository repository; //Injeção de dependência com a interface

	public List<Category> findAll(){
		return repository.findAll(); //Chamando a lista para encontrar o serviço de repositório na Arquiterura do projeto
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}

//@Service Registra a classe como componente do spring, da mesma forma que o @Component, porém com uma semântica mais específica