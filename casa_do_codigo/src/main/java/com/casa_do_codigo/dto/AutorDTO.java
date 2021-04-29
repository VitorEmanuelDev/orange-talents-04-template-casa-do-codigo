package com.casa_do_codigo.dto;

import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.casa_do_codigo.model.Autor;
import com.casa_do_codigo.validator.UniqueValue;

public class AutorDTO {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(targetClass = Autor.class, fieldName = "email")
	private String email;
	@NotBlank
	@Size(max=400)
	private String descricao;
	@Column(name = "instante")
	private Instant instante = Instant.now();

	
	public AutorDTO(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		
	}


	public String getEmail() {
		
		return this.email;
	}


	public Autor toModel() {
		
		return new Autor(nome, email, descricao);
	}

	
}