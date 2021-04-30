package com.casa_do_codigo.autor;

import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.casa_do_codigo.validator.UniqueValue;

public class NovoAutorRequest {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(targetClass = AutorModel.class, fieldName = "email")
	private String email;
	@NotBlank
	@Size(max=400)
	private String descricao;
	@Column(name = "instante")
	private Instant instante = Instant.now();

	
	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		
	}


	public AutorModel toModel() {
		
		return new AutorModel(nome, email, descricao);
	}

	
}