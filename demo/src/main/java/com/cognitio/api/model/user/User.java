package com.cognitio.api.model.user;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class User implements UserDetails{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String nome;

   @NotEmpty(message = "O login não pode estar vazio")
   private String login;

   @NotEmpty(message = "A senha não pode estar vazia")
   private String senha;

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
   }

   @Override
   public String getPassword() {
      return senha;
   }

   @Override
   public String getUsername() {
      return login;
   }
   
}
