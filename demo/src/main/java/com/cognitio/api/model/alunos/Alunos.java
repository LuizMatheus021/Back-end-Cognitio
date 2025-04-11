package com.cognitio.api.model.alunos;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.cognitio.api.model.endereco.Endereco;

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
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    @Embedded
    private Endereco endereco;

    public Alunos(DadosCadastroAlunos dados){
        this.nome = dados.nome();
        this.email = dados.email();    
        this.endereco = new Endereco(dados.Endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoAlunos dados) {    
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {    
            this.email = dados.email();
        }
    }
    
}
