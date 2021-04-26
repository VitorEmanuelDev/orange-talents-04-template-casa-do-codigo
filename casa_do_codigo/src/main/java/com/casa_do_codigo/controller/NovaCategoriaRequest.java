package com.casa_do_codigo.controller;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {
	

	@NotBlank(message = "O campo nome não pode ficar em branco")
	@Column(name = "NOME", unique = true)
	private @NotBlank String nome;
	
	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	public String getNome() {
		
		return nome;
		
	}


}
