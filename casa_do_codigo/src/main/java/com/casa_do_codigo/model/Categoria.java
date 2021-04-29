package com.casa_do_codigo.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "CategoriasDB", uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 3)
	private String nome;
	
	public Categoria(@NotBlank String nome) {
	
		this.nome = nome;
		
	}

	@Override
	public String toString() {
		
		return "Categoria [ID = " + id + ", Nome = " + nome + " ]";	
		
	}

}

