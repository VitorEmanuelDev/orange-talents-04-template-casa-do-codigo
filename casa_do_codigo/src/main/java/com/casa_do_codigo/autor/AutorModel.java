package com.casa_do_codigo.autor;

import java.time.Instant;

import javax.persistence.*;

import javax.validation.constraints.*;

import org.springframework.util.Assert;


@Entity
@Table(name = "AutoresDB", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class AutorModel {
	
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
	public AutorModel() {
		
	}
	

	public AutorModel(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
	
		Assert.hasLength(nome, "Nome é obrigatório.");
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

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
