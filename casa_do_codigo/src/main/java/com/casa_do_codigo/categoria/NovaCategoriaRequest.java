package com.casa_do_codigo.categoria;

import javax.validation.constraints.NotBlank;

import com.casa_do_codigo.validator.UniqueValue;

public class NovaCategoriaRequest {

	 @NotBlank 
	 @UniqueValue(targetClass = CategoriaModel.class, fieldName = "nome")
	 private String nome;
	 
	 @Deprecated
	 public NovaCategoriaRequest() {
		 
	 }
	 
	 public NovaCategoriaRequest(@NotBlank String nome) {
		 this.nome = nome;
		 
	 }
	 
	 public String getNome() {
	     return nome;
	 }
	
	public CategoriaModel toModel() {
		 return new CategoriaModel(nome);
	}

}
