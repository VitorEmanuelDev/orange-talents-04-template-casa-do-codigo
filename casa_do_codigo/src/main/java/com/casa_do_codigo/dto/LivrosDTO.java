package com.casa_do_codigo.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
//import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

import org.springframework.util.Assert;

import com.casa_do_codigo.model.Autor;
import com.casa_do_codigo.model.Categoria;
import com.casa_do_codigo.model.Livro;
import com.casa_do_codigo.validator.ExistsId;
import com.casa_do_codigo.validator.UniqueValue;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.databind.util.Converter;


public class LivrosDTO {

	@NotBlank
	@UniqueValue(targetClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private  String resumo;
	@NotBlank
	private String sumario;
	@NotBlank
	@Min(20)
	private BigDecimal preco;
	@NotBlank
	@Min(100)
	private Integer paginas;
	@NotBlank
	@UniqueValue(targetClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	//@JsonDeserialize(as = Livro.class)
	private @Future LocalDate publicacao;
	@NotNull
	@ExistsId(targetClass = Autor.class, fieldName = "id")
	//@ManyToOne
	private Autor nomeAutor;
	@NotNull
	@ExistsId(targetClass = Categoria.class, fieldName = "id")
	//@ManyToOne
	private Categoria nomeCategoria;

	@JsonCreator
	public LivrosDTO(@NotBlank @JsonProperty("titulo")String titulo, @NotBlank @Size(max = 500) @JsonProperty("resumo") String resumo, @NotBlank @JsonProperty("sumario") String sumario,
			@NotNull @Min(20) @JsonProperty("preco") BigDecimal preco, @Min(100) @NotNull @JsonProperty("paginas") Integer paginas, @NotBlank  @JsonProperty("isbn") String isbn,
			@Future	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING) @JsonProperty("publicacao") LocalDate publicacao, @NotNull @JsonProperty("nomeAutor") @NotNull Autor nomeAutor, @NotNull @JsonProperty("nomeCategoria") @NotNull Categoria nomeCategoria) {
		
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.publicacao = publicacao;
		this.nomeAutor = nomeAutor;
		this.nomeCategoria = nomeCategoria;
	}


	public LivrosDTO(Livro livro) {
	
	}


	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}
	
	
	public void setNomeAutor(Autor nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public void setNomeCategoria(Categoria nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}


	public Livro toModel(EntityManager manager) {
		
		@NotNull Autor autor = manager.find(Autor.class, nomeAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, nomeCategoria);
		
		Assert.state(autor != null, "Autor não pode ser nulo.");
		Assert.state(categoria != null, "Categoria não pode ser nulo.");
		
		
		
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, publicacao, nomeAutor, nomeCategoria);
	}
	

	/*@Override
	public String toString() {
		
		return "Categoria [ID = " + id + ", Titulo = " + titulo + ", Resumo = "
		        + resumo + ", Sumário = " + sumario + ", Preco = " + preco + 
		        ", Paginas = " + paginas + ", ISBN = " + isbn + ", Publicacao = " + publicacao +
		        ", Autor = " + nomeAutor + ", Categoria = " + nomeCategoria + " ]";	
		
	}*/

}
