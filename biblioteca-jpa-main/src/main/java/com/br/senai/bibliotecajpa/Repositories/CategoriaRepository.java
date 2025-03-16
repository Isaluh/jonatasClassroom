package com.br.senai.bibliotecajpa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.senai.bibliotecajpa.Entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
