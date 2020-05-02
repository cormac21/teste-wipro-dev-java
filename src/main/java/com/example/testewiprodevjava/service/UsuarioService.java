package com.example.testewiprodevjava.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.testewiprodevjava.model.user.Usuario;
import com.example.testewiprodevjava.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	UsuarioRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepo.findByLogin(login);
		if( user.isPresent()) {
			return new org.springframework.security.core.userdetails.User(
					user.get().getLogin(), user.get().getSenha(), Collections.emptyList());
		} else {
			throw new UsernameNotFoundException("username not found");
		}
 	}

}
