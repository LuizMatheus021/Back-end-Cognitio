package com.cognitio.api.model.alunos;
import com.cognitio.api.model.endereco.DadosEndereco;

public record DadosAtualizacaoAluno(Integer id, String nome, String email, DadosEndereco endereco, String telefone, String login, String senha,String cpf, String dataDeNascimento) {
} 