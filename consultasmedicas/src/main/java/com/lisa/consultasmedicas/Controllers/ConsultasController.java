package com.lisa.consultasmedicas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lisa.consultasmedicas.Entities.Consulta;
import com.lisa.consultasmedicas.Entities.Consulta.StatusConsulta;
import com.lisa.consultasmedicas.Services.ConsultaService;

@RestController
@RequestMapping("consultas")
public class ConsultasController {
    
    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAllConsultas(){
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public Consulta getConsultaId(@PathVariable Integer id){
        return consultaService.findById(id);
    }

    @PostMapping("/agendamento")
    public Consulta saveConsulta(@RequestBody Consulta consulta) {
        return consultaService.saveConsulta(consulta);
    }

    @PutMapping("/{id}/update")
    public Consulta updateStatus(@PathVariable Integer id, @RequestBody StatusConsulta novoStatus) {
        return consultaService.updateStatus(id, novoStatus);
    }
}
