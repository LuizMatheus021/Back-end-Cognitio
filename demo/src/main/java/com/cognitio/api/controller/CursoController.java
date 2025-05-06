package com.cognitio.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognitio.api.model.cursos.Curso;
import com.cognitio.api.model.cursos.CursoRepository;
import com.cognitio.api.model.cursos.DadosAtualizacaoCurso;
import com.cognitio.api.model.cursos.DadosCadastroCurso;

import jakarta.transaction.Transactional;
@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroCurso dados) {
        cursoRepository.save(new Curso(dados));
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoCurso dados) {  
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Integer id) {
        var curso = cursoRepository.getReferenceById(id);
        cursoRepository.delete(curso);
        
    }
    
}
