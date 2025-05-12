package com.isaluh.apiContatos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaluh.apiContatos.Entities.Contato;
import com.isaluh.apiContatos.Services.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> getAllContatos(){
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public Contato getContatoId(@PathVariable Integer id){
        return contatoService.findById(id);
    }

    @PostMapping("/add")
    public Contato saveContato(@RequestBody Contato contato){
        return contatoService.save(contato);
    }

    @PutMapping("/update")
    public Contato updateContato(@RequestBody Contato contato){
        return contatoService.update(contato);
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable Integer id){
        this.contatoService.delete(id);
    }
}
