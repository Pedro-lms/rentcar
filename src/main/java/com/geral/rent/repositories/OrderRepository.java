package com.geral.rent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.rent.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
