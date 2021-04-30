package com.casa_do_codigo.autor;

import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.casa_do_codigo.validator.UniqueValue;

public class NovoAutorResponse {
	
	private Long id;
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

	
	public NovoAutorResponse(AutorModel autor) {
		
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.instante = autor.getInstante();
		
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		
		return email;
	}
	
	public String getDescricao() {
		return descricao;
	}


	public Instant getInstante() {
		return instante;
	}




	
}