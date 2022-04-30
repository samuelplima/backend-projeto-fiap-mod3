package com.projetofiap.meuvivoapi.service;



import java.util.Optional;

import com.projetofiap.meuvivoapi.model.entity.Usuario;



public interface UsuarioService {

	Usuario autenticar(String cpf, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarCpf(String cpf);
	
	Optional<Usuario> obterPorId(Long id);

	
	
}