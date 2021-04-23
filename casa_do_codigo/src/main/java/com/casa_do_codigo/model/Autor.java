package com.casa_do_codigo.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;

import org.springframework.util.Assert;


@Entity
@Table(name = "CadastrosDB", uniqueConstraints={@UniqueConstraint(columnNames={"EMAIL"})})
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	

	public Autor(@NotBlank(message = "O campo nome não pode ficar em branco") String nome, @NotBlank(message = "O campo e-mail não pode ficar em branco") @Email @Pattern(regexp = ".+@.+\\..+", message = "Informe um e-mail válido") String email, @NotBlank(message = "O campo descrição não pode ficar em branco") @Size(max = 400) String descricao) {
	
		Assert.hasLength(nome, "Nome é obrigatório.");
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

	}

	@Override
	public String toString() {
		
		return "Autor [nome = " + nome + ", email = " + email +	", descricao = " + descricao + "Momento = " + instante + "]";	
		
	}

}
