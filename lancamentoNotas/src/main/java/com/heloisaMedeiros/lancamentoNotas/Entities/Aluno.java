package com.heloisaMedeiros.lancamentoNotas.Entities;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private int matricula;
    private List<Float> notas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Float> getNotas() {
        return notas;
    }

    public void setNotas(List<Float> notas) {
        this.notas = notas;
    }

    public String addNota(float nota){
        if(notas.size() < 3){
            notas.add(nota);
            return "Nota inserida.";
        }
        return "As notas desse aluno ja foram preenchidas.";
    }

    public float calcularMedia(){
        float media = 0;
        for (Float nota : notas) {
            media += nota;
        }
        return (media/notas.size());
    }

    public String verificarAprovacao(){
        if (calcularMedia() >= 6) {
            return "Aluno aprovado.";
        } else if (calcularMedia() >= 4) {
            return "Aluno em recuperação.";
        } else {
            return "Aluno reprovado.";
        }
    }
}
