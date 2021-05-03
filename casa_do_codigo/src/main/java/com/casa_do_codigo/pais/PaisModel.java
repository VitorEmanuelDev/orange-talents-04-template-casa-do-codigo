package com.casa_do_codigo.pais;

import javax.persistence.*;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;


import org.springframework.util.Assert;

@Entity
@Table(name = "PaisesDB", uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class PaisModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 3)
	@Column(unique = true)
	private String nome;
		
	@Deprecated
	public PaisModel() {
		
	}
	

	public PaisModel(@NotBlank String nome) {
	
		Assert.hasLength(nome, "Nome é obrigatório.");
		this.nome = nome;
	
	}
	
	public Long getId() {
		
		return id;
	}

	public String getNome() {
		
		return nome;
	}

}
