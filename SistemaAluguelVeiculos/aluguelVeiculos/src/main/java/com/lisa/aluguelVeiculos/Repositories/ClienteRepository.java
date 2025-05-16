package com.lisa.aluguelVeiculos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lisa.aluguelVeiculos.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
