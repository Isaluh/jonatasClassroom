package com.br.senai.bibliotecajpa.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.senai.bibliotecajpa.Entities.Categoria;
import com.br.senai.bibliotecajpa.Repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        if (categorias.isEmpty()) {
            throw new RuntimeException("Não há categorias cadastradas ainda.");
        }
        return categorias;
    }

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + id));
    }

    public Categoria save(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser cadastrada: Falta de informações.");
        }
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada com ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }

    public Categoria update(Categoria categoria) {
        if (categoria == null || categoria.getId() == null) {
            throw new IllegalArgumentException("Categoria não pode ser atualizada: Falta de informações.");
        }
        return categoriaRepository.save(categoria);
    }
}

