package com.cognitio.api.model.endereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String numero;
    private String uf;
    private String cidade;
    

    public Endereco(DadosEndereco dados){
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.numero = dados.numero();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
    }
    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }    
        if (dados.bairro() != null) {    
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();    
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();    
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();    
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();    
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();    
        }
    }
}

    

