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

import com.lisa.consultasmedicas.Entities.Paciente;
import com.lisa.consultasmedicas.Services.PacienteService;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPacientes(){
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente getPacienteId(@PathVariable Integer id){
        return pacienteService.findById(id);
    }

    @PostMapping("/add")
    public Paciente savePaciente(Paciente paciente){
        return pacienteService.save(paciente);
    }

    @PutMapping("/update")
    public Paciente updatePaciente(Paciente paciente){
        return pacienteService.update(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Integer id){
        this.pacienteService.delete(id);
    }
}
