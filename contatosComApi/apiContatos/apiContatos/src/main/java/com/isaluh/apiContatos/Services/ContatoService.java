package com.isaluh.apiContatos.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaluh.apiContatos.Entities.Contato;
import com.isaluh.apiContatos.Repositories.ContatoRepository;

@Service
public class ContatoService {
    
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> findAll() {
        List<Contato> contatos = contatoRepository.findAll();
        if (contatos.isEmpty()) {
            throw new RuntimeException("Não há contatos cadastradas ainda.");
        }
        return contatos;
    }

    public Contato findById(Integer id) {
        return contatoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contato não encontrada com ID: " + id));
    }

    public Contato save(Contato contato) {
        if (contato == null) {
            throw new IllegalArgumentException("Contato não pode ser cadastrado: Falta de informações.");
        }
        return contatoRepository.save(contato);
    }

    public void delete(Integer id) {
        if (!contatoRepository.existsById(id)) {
            throw new RuntimeException("Contato não encontrada com ID: " + id);
        }
        contatoRepository.deleteById(id);
    }

    public Contato update(Contato contato) {
        if (contato == null || contato.getId() == null) {
            throw new IllegalArgumentException("Contato não pode ser atualizado: Falta de informações.");
        }
        return contatoRepository.save(contato);
    }
}
