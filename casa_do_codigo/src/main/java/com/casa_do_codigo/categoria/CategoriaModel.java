package com.casa_do_codigo.categoria;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "CategoriasDB", uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 3)
	private String nome;
	
	@Deprecated
	public CategoriaModel() {
		
	}
	
	public CategoriaModel(@NotBlank String nome) {
	
		this.nome = nome;
		
	}


	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	

}

