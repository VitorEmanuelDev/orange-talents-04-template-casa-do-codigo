package com.casa_do_codigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.casa_do_codigo.validator.UniqueValue;
//import com.casa_do_codigo.validator.ExistsId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Entity
@Table(name = "LivrosDB")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	//@UniqueValue(targetClass = Livro.class, fieldName = "titulo")
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
	//@UniqueValue(targetClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	//@JsonDeserialize(as = Livro.class)
	private LocalDate publicacao;
	@NotNull
	//@ExistsId(domainClass = Autor.class, fieldName = "id")
	@ManyToOne
	private @NotNull Autor nomeAutor;
	@NotNull
	//@ExistsId(domainClass = Categoria.class, fieldName = "id")
	@ManyToOne
	private @NotNull Categoria nomeCategoria;
	
	@Deprecated
	public Livro() {
		
	}


	@JsonCreator
	public Livro(@NotBlank @JsonProperty("titulo")String titulo, @NotBlank @Size(max = 500) @JsonProperty("resumo") String resumo, @NotBlank @JsonProperty("sumario") String sumario,
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


	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}

	@Override
	public String toString() {
		
		return "Categoria [ID = " + id + ", Titulo = " + titulo + ", Resumo = "
		        + resumo + ", Sumário = " + sumario + ", Preco = " + preco + 
		        ", Paginas = " + paginas + ", ISBN = " + isbn + ", Publicacao = " + publicacao +
		        ", Autor = " + nomeAutor + ", Categoria = " + nomeCategoria + " ]";	
		
	}

}

