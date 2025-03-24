package com.lisa.consultasmedicas.Repositories;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lisa.consultasmedicas.Entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query(value = "SELECT * FROM consulta c WHERE c.medico_id = :id AND " +
               "((CONCAT(c.data, ' ', c.hora) BETWEEN :inicio AND :fim) OR " +
               "(TIMESTAMPADD(MINUTE, c.minutos_consulta, CONCAT(c.data, ' ', c.hora)) BETWEEN :inicio AND :fim))", 
               nativeQuery = true)
    List<Consulta> disponibilidadeMedico(
        @Param("id") Integer medicoId, 
        @Param("inicio") LocalDateTime inicio, 
        @Param("fim") LocalDateTime fim
    );

    @Query(value = "SELECT * FROM consulta c WHERE c.paciente_id = :id AND " +
                "((CONCAT(c.data, ' ', c.hora) BETWEEN :inicio AND :fim) OR " +
                "(TIMESTAMPADD(MINUTE, c.minutos_consulta, CONCAT(c.data, ' ', c.hora)) BETWEEN :inicio AND :fim))", 
                nativeQuery = true)
    List<Consulta> disponibilidadePaciente(
        @Param("id") Integer pacienteId, 
        @Param("inicio") LocalDateTime inicio, 
        @Param("fim") LocalDateTime fim
    );

}
