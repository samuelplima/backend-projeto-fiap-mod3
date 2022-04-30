package com.projetofiap.meuvivoapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

	private String email;
	private String nome;
	private String cpf;
	private String telefone;
	private String senha;
}
