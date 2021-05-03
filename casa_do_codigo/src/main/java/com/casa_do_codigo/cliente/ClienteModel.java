package com.casa_do_codigo.cliente;


import javax.persistence.*;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.br.CPF;

import com.casa_do_codigo.estado.EstadoModel;
import com.casa_do_codigo.pais.PaisModel;


@Entity
@Table(name = "ClientesDB", uniqueConstraints={@UniqueConstraint(columnNames={"email","documento"})})
public class ClienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(min = 3)
	private String nome;
	@NotBlank
	@Size(min = 3)
	private String sobrenome;
	@NotBlank
	@CPF
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ManyToOne
	private PaisModel pais;
	@ManyToOne
    private EstadoModel estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

	@Deprecated 
	public ClienteModel() {
		
	}
	
	public ClienteModel(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, PaisModel pais, @NotBlank String telefone,
			@NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
		
				
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public PaisModel getPais() {
		return pais;
	}

	public EstadoModel getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoModel estado) {
		this.estado = estado; 
		
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	

	

}
