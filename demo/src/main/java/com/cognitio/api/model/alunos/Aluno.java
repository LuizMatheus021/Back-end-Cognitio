package com.cognitio.api.model.alunos;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String cpf;
    private String telefone;
    private String dataDeNascimento;
    

    // @Embedded
    // private Endereco endereco;

    public Aluno(DadosCadastroAluno dados){
        this.nome = dados.nome();
        this.email = dados.email();   
        this.login = dados.login();
        this.senha = dados.senha();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.dataDeNascimento = dados.dataDeNascimento(); 
        // this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoAluno dados) {    
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {    
            this.email = dados.email();
        }
        if (dados.login() != null) {    
            this.login = dados.login();
        }
        if (dados.senha() != null) {    
            this.senha = dados.senha();
        }
        if (dados.cpf() != null) {    
            this.cpf = dados.cpf();
        }
        if (dados.telefone() != null) {    
            this.telefone = dados.telefone();
        }
        if (dados.dataDeNascimento() != null) {    
            this.dataDeNascimento = dados.dataDeNascimento();
        }
    //     if (dados.endereco() != null) {
    //         this.endereco.atualizarInformacoes(dados.endereco());
    // }
    
}
}