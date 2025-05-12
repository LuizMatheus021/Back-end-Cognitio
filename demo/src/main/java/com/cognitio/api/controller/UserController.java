package com.cognitio.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognitio.api.model.domain.user.User;
import com.cognitio.api.model.domain.user.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository ur;

    @Autowired
    private PasswordEncoder passwordEncoder; // Injetando o PasswordEncoder

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        // Aqui você criptografa a senha antes de salvar no banco
        user.setSenha(passwordEncoder.encode(user.getSenha()));

        ur.save(user);
        return ResponseEntity.status(201).body("Usuário cadastrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User usuarioEncontrado = ur.findByLogin(user.getLogin());

        // Se o usuário não for encontrado ou a senha não for válida, retornamos erro
        if (usuarioEncontrado == null || !passwordEncoder.matches(user.getSenha(), usuarioEncontrado.getSenha())) {
            return ResponseEntity.status(401).body("Login ou senha inválidos");
        }

        return ResponseEntity.ok("Login realizado com sucesso!");
    }
}
