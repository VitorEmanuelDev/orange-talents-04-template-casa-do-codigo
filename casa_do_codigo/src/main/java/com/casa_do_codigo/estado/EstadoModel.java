package com.casa_do_codigo.estado;

import javax.persistence.*;

import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.*;


import org.springframework.util.Assert;

import com.casa_do_codigo.pais.PaisModel;

@Entity
@Table(name = "EstadosDB", uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class EstadoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 3)
	private String nome;
	@ManyToOne
	private @NotNull @Valid PaisModel pais;
		
	@Deprecated
	public EstadoModel() {
		
	}
	

	public EstadoModel(@NotBlank String nome, @NotNull @Valid PaisModel pais) {
	
		Assert.hasLength(nome, "Nome é obrigatório.");
		this.nome = nome;
		this.pais = pais;
	
	}
	
	public Long getId() {
		
		return id;
	}

	public String getNome() {
		
		return nome;
	}


	public PaisModel getPais() {
		return pais;
	}



}
