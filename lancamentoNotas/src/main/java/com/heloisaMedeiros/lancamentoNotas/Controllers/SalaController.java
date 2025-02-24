package com.heloisaMedeiros.lancamentoNotas.Controllers;

import com.heloisaMedeiros.lancamentoNotas.Entities.Aluno;
import com.heloisaMedeiros.lancamentoNotas.Entities.Sala;
import com.heloisaMedeiros.lancamentoNotas.Services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @PostMapping("/addSala")
    public String cadastrarSala(@RequestBody Sala sala) {
        return salaService.cadastrarSala(sala);
    }

    @GetMapping
    public List<Sala> listarSalas() {
        return salaService.listarSalas();
    }

    @PostMapping("/{nomeSala}/aluno")
    public String cadastrarAlunoSala(@RequestBody Aluno aluno, @PathVariable String nomeSala){
        return salaService.adicionarAlunoNaSala(aluno, nomeSala);
    }

    @PostMapping("/{nomeSala}/alunos/{matricula}/notas")
    public String adicionarNota(@PathVariable String nomeSala, @PathVariable int matricula, @RequestBody Float nota) {
        return salaService.adicionarAlunoNota(nomeSala, matricula, nota);
    }

    @GetMapping("/{nomeSala}/alunos")
    public String listarAlunosDaSala(@PathVariable String nomeSala) {
        return salaService.listarAlunosDaSala(nomeSala);
    }

}
