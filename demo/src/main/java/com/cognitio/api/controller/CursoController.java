package com.cognitio.api.controller;

import com.cognitio.api.model.cursos.Curso;
import com.cognitio.api.model.cursos.CursoRepository;
import com.cognitio.api.model.cursos.DadosCadastroCurso;
import com.cognitio.api.model.cursos.CursoFormDTO;
import com.cognitio.api.model.cursos.DadosAtualizacaoCurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<String> cadastrar(
            @ModelAttribute CursoFormDTO dados,
            @RequestParam("imagem") MultipartFile imagem) {
        try {
            // Salvar a imagem no servidor
            String imagemUrl = imagem.getOriginalFilename();
            Path destino = Paths.get("uploads", imagemUrl);
            Files.createDirectories(destino.getParent());
            Files.copy(imagem.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

            // Criar objeto DadosCadastroCurso com o caminho da imagem
            DadosCadastroCurso dadosCurso = new DadosCadastroCurso(
                    dados.getNome(),
                    dados.getDescricao(),
                    dados.getCategoria(),
                    dados.getValor(),
                    dados.getConteudo(),
                    destino.toString(),
                    dados.getTags());

            cursoRepository.save(new Curso(dadosCurso));
            return ResponseEntity.ok("Curso cadastrado com sucesso.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoCurso dados) {
        // Lógica de atualização aqui (se ainda for implementar)
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Integer id) {
        var curso = cursoRepository.getReferenceById(id);
        cursoRepository.delete(curso);
    }
}
