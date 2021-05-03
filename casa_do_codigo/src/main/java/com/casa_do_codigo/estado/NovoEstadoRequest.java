package com.casa_do_codigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;

import com.casa_do_codigo.pais.PaisModel;
import com.casa_do_codigo.validator.ExistsId;
import com.casa_do_codigo.validator.UniqueValue;

public class NovoEstadoRequest {

	@NotBlank
	@UniqueValue(targetClass = EstadoModel.class, fieldName = "nome")
	private String nome;
	@NotNull @ExistsId(targetClass = PaisModel.class, fieldName = "id")
	private Long idPais;
	
	@Deprecated
	public NovoEstadoRequest() {
		 
	}
	
	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		
		this.nome = nome;
		this.idPais = idPais;
			
	}
	
	public String getNome() {
		
	    return nome;
	    
	}
	
	public Long getIdPais() {
		
		return idPais;
		
	}

	public EstadoModel toModel(EntityManager manager) {
		 @NotNull PaisModel pais = manager.find(PaisModel.class, idPais);
		return new EstadoModel(nome, pais);
		
	}

}
