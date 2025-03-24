package com.lisa.consultasmedicas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lisa.consultasmedicas.Entities.Medico;
import com.lisa.consultasmedicas.Services.MedicoService;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> getAllMedicos(){
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public Medico getMedicoId(@PathVariable Integer id){
        return medicoService.findById(id);
    }

    @PostMapping("/add")
    public Medico saveMedico(Medico medico){
        return medicoService.save(medico);
    }

    @PutMapping("/update")
    public Medico updateMedico(Medico medico){
        return medicoService.update(medico);
    }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable Integer id){
        this.medicoService.delete(id);
    }
}
