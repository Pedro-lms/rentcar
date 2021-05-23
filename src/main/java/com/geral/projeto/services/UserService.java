package com.geral.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geral.projeto.entities.User;
import com.geral.projeto.repositories.UserRepository;

@Service 
public class UserService {

	@Autowired //O Spring faz a injeção de forma automática e trasnparente
	private UserRepository repository; //Injeção de dependência com a interface

	public List<User> findAll(){
		return repository.findAll(); //Chamando a lista para encontrar o serviço de repositório na Arquiterura do projeto
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}

//@Service Registra a classe como componente do spring, da mesma forma que o @Component, porém com uma semântica mais específica