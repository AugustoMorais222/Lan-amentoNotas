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
        salaService.addSala(sala);
    }

    @PostMapping("/{sala}/alunos")
    public void addAluno(@PathVariable String sala, @RequestBody Aluno aluno) {
        System.out.println(sala);
        System.out.println(aluno.getNome());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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






}
