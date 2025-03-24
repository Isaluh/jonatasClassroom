package com.lisa.consultasmedicas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lisa.consultasmedicas.Entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    
}
