package com.lisa.aluguelVeiculos.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lisa.aluguelVeiculos.Entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    List<Veiculo> findByDisponivelTrue();
}
