package com.isaluh.apiContatos.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaluh.apiContatos.Entities.Contato;
import com.isaluh.apiContatos.Repositories.ContatoRepository;

@Service
public class FavoritosService {

    @Autowired
    private ContatoRepository contatoRepository; 

    public List<Contato> findAllFavoritos() {
        return contatoRepository.findByFavoritoTrue();
    }

    public Contato findById(Integer id) {
        return contatoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contato não encontrado com ID: " + id));
    }

    public void toggleFavorito(Integer contatoId) {
        Contato contato = contatoRepository.findById(contatoId)
            .orElseThrow(() -> new RuntimeException("Contato não encontrado com ID: " + contatoId));

        boolean novoEstadoFavorito = !contato.isFavorito();
        contato.setFavorito(novoEstadoFavorito);

        contatoRepository.save(contato);
    }
}
