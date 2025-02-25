package com.senai.br.lancamentonotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequestMapping("/salas")
@RestController
public class SalaController {

    @Autowired
    SalaService salaService;

    @PostMapping
    public void addSala(@RequestBody Sala sala) {
        try {
        	salaService.addSala(sala);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
    }

    @PostMapping("/{sala}/alunos")
    public void addAluno(@PathVariable String sala, @RequestBody Aluno aluno) {
        salaService.addAluno(sala,aluno);
    }

    @PostMapping("/{sala}/alunos/{matricula}/notas")
    public void lancarNota(@PathVariable String sala, @PathVariable Integer matricula, @RequestBody Double nota) {
        salaService.addNota(sala,matricula,nota);
    }

    @GetMapping("/{sala}/alunos")
    public List<Aluno> listarAlunos(@PathVariable String sala) {
        return salaService.getAlunos(sala);
    }

    @GetMapping("/{sala}/alunos/{matricula}/aprovacao")
    public String aprovacao(@PathVariable String sala, @PathVariable Integer matricula) {
        return salaService.isAprovado(sala,matricula);
    }
    





}
