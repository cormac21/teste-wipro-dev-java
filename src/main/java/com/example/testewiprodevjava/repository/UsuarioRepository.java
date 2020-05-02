package com.example.testewiprodevjava.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testewiprodevjava.model.user.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByLogin(String login);

}
