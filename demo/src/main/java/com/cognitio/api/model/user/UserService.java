package com.cognitio.api.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.cognitio.api.model.user.User usuario = userRepository.findByLoginIgnoreCase(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return User.builder()
        .username(usuario.getLogin())
        .password(usuario.getSenha()) // A senha pode ser criptografada
        .roles("USER")
        .build();
    }

    
}
