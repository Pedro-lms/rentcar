package com.geral.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.projeto.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
