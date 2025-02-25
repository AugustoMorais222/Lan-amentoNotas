package com.senai.br.lancamentonotas;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {
    List<Aluno> alunos = new ArrayList<Aluno>();

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }


}
