package com.lisa.consultasmedicas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lisa.consultasmedicas.Entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    
}