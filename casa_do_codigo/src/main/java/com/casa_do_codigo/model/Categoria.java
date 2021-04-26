package com.casa_do_codigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "CategoriasDB", uniqueConstraints={@UniqueConstraint(columnNames={"NOME"})})
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O campo nome não pode ficar em branco")
	@Column(name = "NOME", unique = true)
	private String nome;
	
	public Categoria(@NotBlank(message = "O campo nome não pode ficar em branco") String nome) {
	
		this.nome = nome;
		
	}

	@Override
	public String toString() {
		
		return "Categoria [ID = " + id + "Nome = " + nome + " ]";	
		
	}

}

