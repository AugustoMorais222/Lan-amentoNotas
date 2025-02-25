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
    
    public Double calcularMedia(List<Double> notas){
    	if (notas == null || notas.isEmpty()) {
            return 0.0;
        }
    	Double media = 0.0;
    	for(Double nota : notas) {
    		media += nota;
    	}
    	return media / (notas.size());
    }
    
    public String isAprovado(String nomeSala, Integer matricula){
		for(Sala sala : salas){
			if(sala.getNome().equals(nomeSala)) {
			    for (Aluno aluno : sala.getAlunos()) {
			        if (aluno.getMatricula().equals(matricula)) {
			        	if(calcularMedia(aluno.getNotas())>= 6.0) {
			        		return "Aprovado";
			        	}
			         
			        }
			    }
			}
		}
		return "Reprovado";
    }

    public void addNota(String nomeSala,Integer matricula, Double nota) {
        for(Sala sala : salas){
            if(sala.getNome().equals(nomeSala)) {
                for (Aluno aluno : sala.getAlunos()) {
                    if (aluno.getMatricula().equals(matricula)) {
                        aluno.addNota(nota);
                        break;
                    }
                }
            }
        }
    }
    
    public Set<Sala> listarSalas(){
    	return this.salas;
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
