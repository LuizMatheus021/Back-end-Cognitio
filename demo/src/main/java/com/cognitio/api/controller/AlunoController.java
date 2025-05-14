package com.cognitio.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.cognitio.api.model.alunos.Aluno;
import com.cognitio.api.model.alunos.AlunoRepository;
import com.cognitio.api.model.alunos.DadosAtualizacaoAluno;
import com.cognitio.api.model.alunos.DadosCadastroAluno;



@RestController 
@Controller
@RequestMapping("/aluno")  
public class AlunoController {
    
    @Autowired
    private AlunoRepository alunoRepository; 

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroAluno dados) {
        alunoRepository.save(new Aluno(dados));
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoAluno dados) {
        var alunos = alunoRepository.getReferenceById(dados.id());
        alunos.atualizarInformacoes(dados);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Integer id) {
        var aluno = alunoRepository.getReferenceById(id);
        alunoRepository.delete(aluno);
    }

    
}
