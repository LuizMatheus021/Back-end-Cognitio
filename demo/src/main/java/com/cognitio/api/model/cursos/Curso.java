package com.cognitio.api.model.cursos;
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


    public Curso(DadosCadastroCurso dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.categoria = dados.categoria();
        this.valor = dados.valor();
        this.conteudo = dados.conteudo();
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
        
}
}

