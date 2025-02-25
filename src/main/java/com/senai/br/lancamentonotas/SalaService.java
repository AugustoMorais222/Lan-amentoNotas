package com.senai.br.lancamentonotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SalaService {
    Set<Sala> salas = new HashSet<Sala>();
    List<Aluno> alunos = new ArrayList<>();
    List<Double> notas = new ArrayList<>();

    public void addSala(Sala sala) {
        this.salas.add(sala);
    }

    public void addAluno(String nomeSala,Aluno aluno) {
        for(Sala sala : salas){
            if(sala.getNome().equals(nomeSala)){
                sala.addAluno(aluno);
                break;
            }
        }
    }

    public void addNota(String nomeSala,Integer matricula, Double nota) {
        for(Sala sala : salas){
            if(sala.getNome().equals(nomeSala)) {
                for (Aluno aluno : sala.getAlunos()) {
                    if (aluno.getMatricula() == matricula) {
                        aluno.addNota(nota);
                        break;
                    }
                }
            }
        }
    }

    public List<Aluno> getAlunos(String nomeSala) {
        for(Sala sala : salas) {
            if(sala.getNome().equals(nomeSala)) {
                return sala.getAlunos();
            }
        }
        return new ArrayList<>();
    }
}
