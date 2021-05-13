package com.geral.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.projeto.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
