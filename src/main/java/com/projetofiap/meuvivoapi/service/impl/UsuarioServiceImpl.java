package com.projetofiap.meuvivoapi.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetofiap.meuvivoapi.service.UsuarioService;
import com.projetofiap.meuvivoapi.exception.ErroAutenticacao;
import com.projetofiap.meuvivoapi.exception.RegraNegocioException;
import com.projetofiap.meuvivoapi.model.entity.Usuario;
import com.projetofiap.meuvivoapi.model.repository.UsuarioRepository;




@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository repository;
	private PasswordEncoder encoder;
	
	public UsuarioServiceImpl(
			UsuarioRepository repository, 
			PasswordEncoder encoder) {
		super();
		this.repository = repository;
		this.encoder = encoder;
	}

	@Override
	public Usuario autenticar(String cpf, String senha) {
		Optional<Usuario> usuario = repository.findByCpf(cpf);
		
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado para o email informado.");
		}
		
		boolean senhasBatem = encoder.matches(senha, usuario.get().getSenha());
		
		if(!senhasBatem) {
			throw new ErroAutenticacao("Senha inválida.");
		}

		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarCpf(usuario.getCpf());
		criptografarSenha(usuario);
		return repository.save(usuario);
	}

	private void criptografarSenha(Usuario usuario) {
		String senha = usuario.getSenha();
		String senhaCripto = encoder.encode(senha);
		usuario.setSenha(senhaCripto);
	}

	@Override
	public void validarCpf(String cpf) {
		boolean existe = repository.existsByCpf(cpf);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}

	}

	@Override
	public Optional<Usuario> obterPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
