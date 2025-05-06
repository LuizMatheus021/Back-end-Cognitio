package com.cognitio.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognitio.api.model.professor.DadosAtualizacaoProfessor;
import com.cognitio.api.model.professor.DadosCadastroProfessor;
import com.cognitio.api.model.professor.Professor;
import com.cognitio.api.model.professor.ProfessorRepository;

@RestController
@Controller
@RequestMapping("/professor")


public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroProfessor dados) {
        professorRepository.save(new Professor(dados));
            
    }
    
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoProfessor dados) {
        var professor = professorRepository.getReferenceById(dados.id());
        professor.atualizarInformacoes(dados);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Integer id) {
        var professor = professorRepository.getReferenceById(id);
        professorRepository.delete(professor);
    }
       
    
}
