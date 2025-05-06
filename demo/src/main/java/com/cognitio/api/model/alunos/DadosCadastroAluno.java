package com.cognitio.api.model.alunos;
import com.cognitio.api.model.endereco.DadosEndereco;

public record DadosCadastroAluno(String nome, String email, DadosEndereco endereco, String telefone, String login, String senha, String cpf, String dataDeNascimento) {
    
}
    

//Nosso DTO vai receber dados do insonia e converter para o BD.