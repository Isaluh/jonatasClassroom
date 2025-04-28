package com.isaluh.apiContatos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaluh.apiContatos.Entities.Grupo;
import com.isaluh.apiContatos.Services.GrupoService;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<Grupo> getAllContatos(){
        return grupoService.findAll();
    }

    @PostMapping("/add")
    public Grupo saveContato(@RequestBody Grupo grupo){
        return grupoService.save(grupo);
    }
}
