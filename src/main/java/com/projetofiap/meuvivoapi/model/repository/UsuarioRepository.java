package com.projetofiap.meuvivoapi.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofiap.meuvivoapi.model.entity.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	

	
	Optional<Usuario> findByCpf(String cpf);

	boolean existsByCpf(String cpf);
	
}
