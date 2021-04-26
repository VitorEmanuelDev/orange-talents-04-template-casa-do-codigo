package com.casa_do_codigo.controller;

import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.casa_do_codigo.model.Autor;


public class NovoAutorRequest {
	

	@NotBlank(message = "O campo nome não pode ficar em branco")
	@Column(name = "NOME")
	private String nome;
	@NotBlank(message = "O campo e-mail não pode ficar em branco")
	@Email
	@Pattern(regexp=".+@.+\\..+", message = "Informe um e-mail válido")
	@Column(name = "EMAIL", unique = true)
	private String email;
	@NotBlank(message = "O campo descrição não pode ficar em branco")
	@Size(max=400)
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "MOMENTO")
	private Instant instante = Instant.now();

	
	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		
	}

	public Autor toModel() {
		
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		
		return this.email;
	}

	
}