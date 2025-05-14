package com.cognitio.api.model.professor;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String login;
    private String senha;
    private String cpf;
    private String dataDeNascimento;
    
    
    // @Embedded
    // private Endereco endereco;

    public Professor(DadosCadastroProfessor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        // this.endereco = new Endereco(dados.Endereco());
        this.telefone = dados.telefone();
        this.login = dados.login();
        this.senha = dados.senha();
        this.cpf = dados.cpf();
        this.dataDeNascimento = dados.dataDeNascimento();
    }

    public void atualizarInformacoes(DadosAtualizacaoProfessor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        // if (dados.endereco() != null) {
        //     this.endereco.atualizarInformacoes(dados.endereco());
        // }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
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
        if (dados.dataDeNascimento() != null) {
            this.dataDeNascimento = dados.dataDeNascimento();
        }
    }

    
}
