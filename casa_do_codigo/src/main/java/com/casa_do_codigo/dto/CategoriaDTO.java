package com.casa_do_codigo.dto;

import javax.validation.constraints.NotBlank;

import com.casa_do_codigo.model.Categoria;
import com.casa_do_codigo.validator.UniqueValue;

public class CategoriaDTO {
	

	@NotBlank
	@UniqueValue(targetClass = Categoria.class, fieldName = "nome")
	private @NotBlank String nome;
	
	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	public String getNome() {
		
		return nome;
		
	}


}