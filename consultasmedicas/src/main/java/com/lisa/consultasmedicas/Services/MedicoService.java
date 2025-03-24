package com.lisa.consultasmedicas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisa.consultasmedicas.Entities.Medico;
import com.lisa.consultasmedicas.Repositories.MedicoRepository;

@Service
public class MedicoService {
    
    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        List<Medico> medicos = medicoRepository.findAll();
        if (medicos.isEmpty()) {
            throw new RuntimeException("Não há médicos registrados no sistema ainda.");
        }
        return medicos;
    }

    public Medico findById(Integer id) {
        return medicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Médico não encontrado do ID: " + id));
    }

    public Medico save(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Médico não pode ser registrado: Falta de informações.");
        }
        return medicoRepository.save(medico);
    }

    public void delete(Integer id) {
        if (!medicoRepository.existsById(id)) {
            throw new RuntimeException("Médico não encontrado do ID: " + id);
        }
        medicoRepository.deleteById(id);
    }

    public Medico update(Medico medico) {
        if (medico == null || medico.getId() == null) {
            throw new IllegalArgumentException("Médico não pode ser atualizado: Falta de informações.");
        }
        return medicoRepository.save(medico);
    }
}
