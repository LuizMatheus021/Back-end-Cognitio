package com.cognitio.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.cognitio.api.model.alunos.Alunos;
import com.cognitio.api.model.alunos.AlunosRepository;
import com.cognitio.api.model.alunos.DadosAtualizacaoAlunos;
import com.cognitio.api.model.alunos.DadosCadastroAlunos;



@RestController 
@RequestMapping("/alunos")  

public class AlunosController {
    
    @Autowired
    private AlunosRepository alunosRepository; 
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroAlunos dados) {
        alunosRepository.save(new Alunos(dados));
            
    }
    
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoAlunos dados) {
        var alunos = alunosRepository.getReferenceById(dados.id());
        alunos.atualizarInformacoes(dados);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Integer id) {
        var alunos = alunosRepository.getReferenceById(id);
        alunosRepository.delete(alunos);
    }
    
}
//O GetMapping serve para listar as informações de cada model