package com.casa_do_codigo.dto;

import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.casa_do_codigo.model.Autor;
import com.casa_do_codigo.validator.UniqueValue;

public class AutorDto {
	
	@NotBlank(message = "O campo nome não pode ficar em branco")
	@Column(name = "NOME")
	private String nome;
	@NotBlank(message = "O campo e-mail não pode ficar em branco")
	@Email
	@Pattern(regexp=".+@.+\\..+", message = "Informe um e-mail válido")
	@UniqueValue(domainClass = Autor.class, fieldName = "EMAIL")
	@Column(name = "EMAIL", unique = true)
	private String email;
	@NotBlank(message = "O campo descrição não pode ficar em branco")
	@Size(max=400)
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "MOMENTO")
	private Instant instante = Instant.now();

	
	public AutorDto(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		
	}

/*
	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public Instant getInstante() {
		return this.instante;
	}*/

	public String getEmail() {
		
		return this.email;
	}


	public Autor toModel() {
		
		return new Autor(this.nome, this.email, this.descricao);
	}

	
}