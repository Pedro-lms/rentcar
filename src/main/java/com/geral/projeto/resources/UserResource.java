package com.geral.projeto.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geral.projeto.entities.User;

@RestController
@RequestMapping(value = "/users")  //Define o caminho do recurso de acordo com o mapeamento do objeto relacionado na localhost, ou no acesso
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Pedro", "pedrodaluzmachado@gmail.com", "988888", "9999");
		return ResponseEntity.ok().body(u);
	}
}
