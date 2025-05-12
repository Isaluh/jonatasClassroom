package com.isaluh.apiContatos.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isaluh.apiContatos.Entities.Grupo;
import com.isaluh.apiContatos.Repositories.GrupoRepository;

@Service
public class GrupoService {
    @Autowired
    private GrupoRepository grupoRepository; 

    public List<Grupo> findAll() {
        List<Grupo> grupos = grupoRepository.findAll();
        if (grupos.isEmpty()) {
            throw new RuntimeException("Não há grupos cadastrados ainda.");
        }
        return grupos;
    }
    
    public Grupo save(Grupo grupo) {
        if (grupo == null) {
            throw new IllegalArgumentException("Grupo não pode ser cadastrado: Falta de informações.");
        }
        return grupoRepository.save(grupo);
    }
}
