package com.cognitio.api.model.alunos;

import com.cognitio.api.model.endereco.DadosEndereco;

public record DadosCadastroAlunos(String nome, String email, DadosEndereco Endereco) {
    
}
    

//Nosso DTO vai receber dados do insonia e converter para o BD.