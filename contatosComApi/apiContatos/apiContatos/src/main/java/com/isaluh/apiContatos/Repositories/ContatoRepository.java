package com.isaluh.apiContatos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaluh.apiContatos.Entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
    
}
