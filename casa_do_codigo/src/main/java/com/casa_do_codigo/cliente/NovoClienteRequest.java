package com.casa_do_codigo.cliente;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.br.CPF;

import com.casa_do_codigo.estado.EstadoModel;
import com.casa_do_codigo.pais.PaisModel;
import com.casa_do_codigo.validator.ExistsId;
import com.casa_do_codigo.validator.UniqueValue;

public class NovoClienteRequest {
	
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
	@UniqueValue(targetClass = ClienteModel.class, fieldName ="documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@ExistsId(targetClass= PaisModel.class, fieldName="id")
	private Long idPais;
	private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;


	public NovoClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String telefone,
			@NotBlank String cep, Long idPais, Long idEstado) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.idPais = idPais;
		this.idEstado = idEstado;
		
				
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



	public Long getIdPais() {
		return idPais;
	}



	public Long getIdEstado() {
		return idEstado;
	}
	
	public void setEstadoId(Long idEstado) {
        this.idEstado = idEstado;
    }



	public String getTelefone() {
		return telefone;
	}



	public String getCep() {
		return cep;
	}



	public ClienteModel toModel(EntityManager manager) {
		PaisModel pais =manager.find(PaisModel.class, idPais);
   
        ClienteModel cliente = new  ClienteModel(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
        if(idEstado != null){
            EstadoModel estado = manager.find(EstadoModel.class, idEstado);
            cliente.setEstado(estado);
        }

        return cliente;
	}
	


	
}