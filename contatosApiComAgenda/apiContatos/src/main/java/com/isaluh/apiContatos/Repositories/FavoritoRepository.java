package com.isaluh.apiContatos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaluh.apiContatos.Entities.Favoritos;

public interface FavoritoRepository extends JpaRepository<Favoritos, Integer> {
    
}
