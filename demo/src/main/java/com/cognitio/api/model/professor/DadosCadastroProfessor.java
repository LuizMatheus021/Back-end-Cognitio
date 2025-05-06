package com.cognitio.api.model.professor;

import com.cognitio.api.model.endereco.DadosEndereco;

public record DadosCadastroProfessor (String nome, String email, String curso, DadosEndereco Endereco, String telefone, String login, String senha, String cpf, String dataDeNascimento) {
    
}
