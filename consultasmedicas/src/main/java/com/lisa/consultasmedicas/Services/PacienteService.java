package com.lisa.consultasmedicas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisa.consultasmedicas.Entities.Paciente;
import com.lisa.consultasmedicas.Repositories.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        if (pacientes.isEmpty()) {
            throw new RuntimeException("Não há pacientes registrados no sistema ainda.");
        }
        return pacientes;
    }

    public Paciente findById(Integer id) {
        return pacienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado do ID: " + id));
    }

    public Paciente save(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente não pode ser registrado: Falta de informações.");
        }
        return pacienteRepository.save(paciente);
    }

    public void delete(Integer id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RuntimeException("Paciente não encontrado do ID: " + id);
        }
        pacienteRepository.deleteById(id);
    }

    public Paciente update(Paciente paciente) {
        if (paciente == null || paciente.getId() == null) {
            throw new IllegalArgumentException("Paciente não pode ser atualizado: Falta de informações.");
        }
        return pacienteRepository.save(paciente);
    }
}
