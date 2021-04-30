package com.casa_do_codigo.categoria;

import javax.validation.constraints.NotBlank;

import com.casa_do_codigo.validator.UniqueValue;

public class NovaCategoriaResponse {
	
	private Long id;
	@NotBlank
	@UniqueValue(targetClass = CategoriaModel.class, fieldName = "nome")
	private @NotBlank String nome;
	
	
	public NovaCategoriaResponse(CategoriaModel categoria) {
		
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		
	}

	public Long getId() {
		
		return id;
		
	}
	
	public String getNome() {
		
		return nome;
		
	}




}