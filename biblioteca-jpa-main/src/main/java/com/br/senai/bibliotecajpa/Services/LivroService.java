package com.br.senai.bibliotecajpa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.senai.bibliotecajpa.Entities.Livro;
import com.br.senai.bibliotecajpa.Repositories.LivroRepository;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        List<Livro> livros = livroRepository.findAll();
        if (livros.isEmpty()) {
            throw new RuntimeException("Não há livros cadastrados ainda.");
        }
        return livros;
    }

    public Livro findById(Integer id) {
        return livroRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));
    }

    public Livro save(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser cadastrado: Falta de informações.");
        }
        return livroRepository.save(livro);
    }

    public void delete(Integer id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado com ID: " + id);
        }
        livroRepository.deleteById(id);
    }

    public Livro update(Livro livro) {
        if (livro == null || livro.getId() == null) {
            throw new IllegalArgumentException("Livro não pode ser atualizado: Falta de informações.");
        }
        return livroRepository.save(livro);
    }

    public List<Livro> findByTittle(String palavra) {
        List<Livro> livros = livroRepository.findByTitle(palavra);
        if (livros.isEmpty()) {
            throw new RuntimeException("Livro não encontrado com o título: " + palavra);
        }
        return livros;
    }

    public List<Livro> findByAutor(String autor) {
        List<Livro> livros = livroRepository.findByAutor(autor);
        if (livros.isEmpty()) {
            throw new RuntimeException("Livro não encontrado com o autor: " + autor);
        }
        return livros;
    }

    public List<Livro> findByCategoria(String categoria) {
        List<Livro> livros = livroRepository.findByCategoria(categoria);
        if (livros.isEmpty()) {
            throw new RuntimeException("Nenhum livro na categoria: " + categoria);
        }
        return livros;
    }

    public List<Livro> findByDisponibilidade() {
        List<Livro> livros = livroRepository.findByDisponibilidade();
        if (livros.isEmpty()) {
            throw new RuntimeException("Nenhum livro disponível no momento");
        }
        return livros;
    }
}

