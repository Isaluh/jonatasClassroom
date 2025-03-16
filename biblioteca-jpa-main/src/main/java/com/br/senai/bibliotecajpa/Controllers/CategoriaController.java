package com.br.senai.bibliotecajpa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.senai.bibliotecajpa.Entities.Categoria;
import com.br.senai.bibliotecajpa.Services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategorias(){
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaId(@PathVariable Integer id){
        return categoriaService.findById(id);
    }

    @PostMapping("/add")
    public Categoria saveCategoria(Categoria categoria){
        return categoriaService.save(categoria);
    }

    @PutMapping("/update")
    public Categoria updateCategoria(Categoria categoria){
        return categoriaService.update(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Integer id){
        this.categoriaService.delete(id);
    }
    
}
