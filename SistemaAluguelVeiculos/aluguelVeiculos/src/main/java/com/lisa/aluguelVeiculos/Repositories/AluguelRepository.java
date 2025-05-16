package com.lisa.aluguelVeiculos.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lisa.aluguelVeiculos.Entities.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Integer>{
    List<Aluguel> findByDataFimIsNull();
}
