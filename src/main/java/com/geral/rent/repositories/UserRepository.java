package com.geral.rent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.rent.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
