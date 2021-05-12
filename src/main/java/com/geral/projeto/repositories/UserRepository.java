package com.geral.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.projeto.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
