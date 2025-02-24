package com.heloisaMedeiros.lancamentoNotas.Entities;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nomeSala;
    private List<Aluno> alunos = new ArrayList<>();

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void addAlunos(Aluno aluno){
        alunos.add(aluno);
    }
}
