package com.isaluh.apiContatos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaluh.apiContatos.Entities.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    
}
