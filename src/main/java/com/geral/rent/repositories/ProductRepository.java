package com.geral.rent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.rent.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
