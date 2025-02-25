package com.senai.br.lancamentonotas;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nome;
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public Sala(String nome, List<Aluno> alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
