package com.geral.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.projeto.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
