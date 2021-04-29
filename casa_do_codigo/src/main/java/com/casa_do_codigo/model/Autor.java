package com.casa_do_codigo.model;

import java.time.Instant;

import javax.persistence.*;

import javax.validation.constraints.*;

import org.springframework.util.Assert;


@Entity
@Table(name = "AutoresDB", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 3)
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank(message = "O campo descrição não pode ficar em branco")
	@Size(max=400)
	private String descricao;
	private Instant instante = Instant.now();
	
	@Deprecated
	public Autor() {
		
	}
	

	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
	
		Assert.hasLength(nome, "Nome é obrigatório.");
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

	}

	@Override
	public String toString() {
		
		return "Autor [Nome = " + nome + ", E-mail = " + email +	", Descrição = " + descricao + "Momento = " + instante + " ]";	
		
	}

}
