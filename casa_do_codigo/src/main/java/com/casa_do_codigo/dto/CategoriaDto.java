package com.casa_do_codigo.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.casa_do_codigo.model.Categoria;
import com.casa_do_codigo.validator.UniqueValue;

public class CategoriaDto {
	

	@NotBlank(message = "O campo nome não pode ficar em branco")
	@Column(name = "NOME", unique = true)
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private @NotBlank String nome;
	
	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	public String getNome() {
		
		return nome;
		
	}


}
