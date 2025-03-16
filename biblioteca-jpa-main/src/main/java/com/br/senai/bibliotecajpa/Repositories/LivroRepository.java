package com.br.senai.bibliotecajpa.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.senai.bibliotecajpa.Entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query(value = "SELECT * FROM livros l WHERE LOWER(l.titulo) LIKE LOWER(CONCAT('%', :palavra, '%'))", nativeQuery = true)
    List<Livro> findByTitle(@Param("palavra") String palavra);

    @Query(value = "SELECT * FROM livros l WHERE LOWER(l.autor) LIKE LOWER(CONCAT('%', :autor, '%'))", nativeQuery = true)
    List<Livro> findByAutor(@Param("autor") String autor);
    
    @Query(value = "SELECT l.* FROM livros l JOIN categorias c ON l.categoria_id = c.id WHERE LOWER(c.nome) = LOWER(:categoria)", nativeQuery = true)
    List<Livro> findByCategoria(@Param("categoria") String categoria);

    @Query(value = "SELECT * FROM livros l WHERE l.quantidade_disponivel > 0", nativeQuery = true)
    List<Livro> findByDisponibilidade();
}
