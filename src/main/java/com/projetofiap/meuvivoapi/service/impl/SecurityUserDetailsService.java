package com.projetofiap.meuvivoapi.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetofiap.meuvivoapi.model.entity.Usuario;
import com.projetofiap.meuvivoapi.model.repository.UsuarioRepository;



@Service
public class SecurityUserDetailsService implements UserDetailsService {
	
	private UsuarioRepository usuarioRepository;

	public SecurityUserDetailsService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Usuario usuarioEncontrado = usuarioRepository
				.findByCpf(cpf)
				.orElseThrow(() -> new UsernameNotFoundException("CPF não cadastrado."));
		
		return User.builder()
				.username(usuarioEncontrado.getCpf())
				.password(usuarioEncontrado.getSenha())
				.roles("USER")
				.build();
	}

}
