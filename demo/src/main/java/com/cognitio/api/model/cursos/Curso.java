package com.cognitio.api.model.cursos;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "cursos")

public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    private String nome;
    private String descricao;
    private String categoria;
    private Double valor;
    private String conteudo; 
    private String imagemUrl; 

    @ElementCollection
    private List<String> tags = new ArrayList<>();



    public Curso(DadosCadastroCurso dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.categoria = dados.categoria();
        this.valor = dados.valor();
        this.conteudo = dados.conteudo();
        this.imagemUrl = dados.imagemUrl();

    }
    public void atualizarInformacoes(DadosCadastroCurso dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();
        }
        if (dados.conteudo() != null) {
            this.conteudo = dados.conteudo();
        }
        if (dados.imagemUrl() != null) {
            this.imagemUrl = dados.imagemUrl();
        }
        
}
}

