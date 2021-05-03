package com.casa_do_codigo.pais;

import javax.validation.constraints.*;

import com.casa_do_codigo.validator.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(targetClass = PaisModel.class, fieldName = "nome")
	private String nome;
	
	 
	 @Deprecated
	 public NovoPaisRequest() {
		 
	 }
	
	public NovoPaisRequest(@NotBlank String nome) {
		
		this.nome = nome;
			
	}
	
	public String getNome() {
		
	    return nome;
	    
	}
	
	
	public PaisModel toModel() {

		return new PaisModel(nome);
		
	}

}
