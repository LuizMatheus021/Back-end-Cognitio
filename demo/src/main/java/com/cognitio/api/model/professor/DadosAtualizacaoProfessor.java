package com.cognitio.api.model.professor;

import com.cognitio.api.model.endereco.DadosEndereco;

public record DadosAtualizacaoProfessor(Integer id,String nome, String email, String curso, DadosEndereco endereco, String telefone, String login, String senha, String cpf, String dataDeNascimento) {

}
