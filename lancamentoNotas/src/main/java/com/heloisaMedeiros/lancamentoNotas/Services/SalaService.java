package com.heloisaMedeiros.lancamentoNotas.Services;

import com.heloisaMedeiros.lancamentoNotas.Entities.Aluno;
import com.heloisaMedeiros.lancamentoNotas.Entities.Sala;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaService {
    private List<Sala> salas = new ArrayList<>();

    public String cadastrarSala(Sala sala){
        salas.add(sala);
        return "Sala cadastrada";
    }

    public List<Sala> listarSalas(){
        return salas;
    }

    public String listarAlunosDaSala(String nomeSala) {
        for (Sala sala : salas) {
            if (sala.getNomeSala().equalsIgnoreCase(nomeSala)) {
                StringBuilder result = new StringBuilder("Alunos da sala " + nomeSala + ":\n");
                for (Aluno aluno : sala.getAlunos()) {
                    result.append(aluno.getNome())
                            .append(" - ")
                            .append("Média: " + aluno.calcularMedia())
                            .append(" - ")
                            .append(aluno.verificarAprovacao())
                            .append("\n");
                }
                return result.toString();
            }
        }
        return "Sala não encontrada!";
    }

    public String adicionarAlunoNaSala(Aluno aluno, String nomeSala) {
        for (Sala sala : salas) {
            if (sala.getNomeSala().equalsIgnoreCase(nomeSala)) {
                sala.addAlunos(aluno);
                return "Aluno cadastrado na sala " + nomeSala + " com sucesso!";
            }
        }
        return "Sala não encontrada!";
    }

    public String adicionarAlunoNota(String nomeSala, int matricula, float nota) {
        for (Sala sala : salas) {
            if (sala.getNomeSala().equalsIgnoreCase(nomeSala)) {
                for (Aluno aluno : sala.getAlunos()) {
                    if (aluno.getMatricula() == matricula) {
                        return aluno.addNota(nota);
                    }
                }
                return "Aluno não encontrado!";
            }
        }
        return "Sala não encontrada!";
    }
}
