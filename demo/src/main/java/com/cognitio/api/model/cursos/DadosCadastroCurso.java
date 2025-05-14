package com.cognitio.api.model.cursos;

import java.util.List;

public record DadosCadastroCurso(String nome, String descricao, String categoria, Double valor, String conteudo, String imagemUrl, List<String> tags) {
    
}
