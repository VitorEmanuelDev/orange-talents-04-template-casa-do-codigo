package com.casa_do_codigo.estado;

import javax.validation.constraints.*;

import com.casa_do_codigo.pais.PaisModel;
import com.casa_do_codigo.validator.UniqueValue;


public class NovoEstadoResponse {

	private Long id;
	@NotBlank 
	@UniqueValue(targetClass = EstadoModel.class, fieldName = "nome")
	private String nome;
	
	public NovoEstadoResponse(EstadoModel estado) {
		
		this.id = estado.getId();
		this.nome = estado.getNome();
		
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


}
