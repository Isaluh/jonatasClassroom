package com.heloisaMedeiros.lancamentoNotas.Controllers;

import com.heloisaMedeiros.lancamentoNotas.Entities.Aluno;
import com.heloisaMedeiros.lancamentoNotas.Services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("addAluno")
public class AlunoController {

    @Autowired
    private SalaService salaService;

    @PostMapping
    public String cadastrarAluno(@RequestBody Aluno aluno, @RequestParam String nomeSala){
        return salaService.adicionarAlunoNaSala(aluno, nomeSala);
    }
}
