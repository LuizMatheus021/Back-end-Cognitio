package com.cognitio.api.model.alunos;

public record DadosCadastroAluno(String nome, String email, String telefone, String login, String senha, String cpf, String dataDeNascimento) {
    
}
    

//Nosso DTO vai receber dados do insonia e converter para o BD.