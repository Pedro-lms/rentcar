package com.geral.rent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.rent.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
