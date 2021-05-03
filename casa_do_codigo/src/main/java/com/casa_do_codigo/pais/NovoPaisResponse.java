package com.casa_do_codigo.pais;

import javax.validation.constraints.*;

import com.casa_do_codigo.validator.UniqueValue;


public class NovoPaisResponse {

	private Long id;
	@NotBlank 
	@UniqueValue(targetClass = PaisModel.class, fieldName = "nome")
	private String nome;
	
	public NovoPaisResponse(PaisModel pais) {
		
		this.id = pais.getId();
		this.nome = pais.getNome();
		
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}

	
}
