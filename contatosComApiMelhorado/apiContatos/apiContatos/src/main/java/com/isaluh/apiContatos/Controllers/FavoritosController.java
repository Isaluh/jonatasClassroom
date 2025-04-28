package com.isaluh.apiContatos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaluh.apiContatos.Entities.Contato;
import com.isaluh.apiContatos.Services.FavoritosService;

@RestController
@RequestMapping("/favoritos")
public class FavoritosController {

    @Autowired
    private FavoritosService favoritosService;

    @GetMapping
    public List<Contato> listarFavoritos() {
        return favoritosService.findAllFavoritos();
    }

    @PutMapping("/update/{id}")
    public void toggleFavorito(@PathVariable Integer id) {
        favoritosService.toggleFavorito(id);
    }
}
