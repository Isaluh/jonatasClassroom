package com.isaluh.apiContatos.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaluh.apiContatos.Entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
    List<Contato> findByFavoritoTrue();
}
