package com.cognitio.api.model.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognitio.api.model.domain.user.UserRepository;

@Service
public class AutorizacaoService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Encontra o usuário no banco de dados
        com.cognitio.api.model.domain.user.User usuario = repository.findByLogin(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        // Retorna os detalhes do usuário, com senha criptografada
        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha()) // A senha pode ser criptografada
                .roles("USER")
                .build();
    }
}
