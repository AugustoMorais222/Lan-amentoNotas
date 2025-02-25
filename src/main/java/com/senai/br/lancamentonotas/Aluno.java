package com.senai.br.lancamentonotas;

import java.util.ArrayList;
import java.util.List;


public class Aluno {
    private String nome;
    private Integer matricula;
    private List<Double> notas;

    public Aluno() {

    }

    public String getNome() {
        return nome;
    }

    public void addNota(Double nota) {
        this.notas.add(nota);
    }



    private Double calcularMedia(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }
        Double media = 0.0;
        for (Double nota : notas) {
            media += nota;
        }
        return media / (notas.size());
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}
