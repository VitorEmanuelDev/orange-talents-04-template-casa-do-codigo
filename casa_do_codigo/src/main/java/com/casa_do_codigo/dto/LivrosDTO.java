package com.casa_do_codigo.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.util.Assert;

import com.casa_do_codigo.model.Autor;
import com.casa_do_codigo.model.Categoria;
import com.casa_do_codigo.model.Livro;
//import com.casa_do_codigo.validator.ExistsId;
import com.casa_do_codigo.validator.UniqueValue;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.databind.util.Converter;


public class LivrosDTO {

	@NotBlank
	@UniqueValue(targetClass = Livro.class,fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@Min(100)
	private int paginas;
	@NotBlank
	@UniqueValue(targetClass = Livro.class,fieldName = "isbn")
	private String isbn;
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate publicacao;
	@NotNull
	//@ExistsId(targetClass = Autor.class, fieldName = "id")
	@Valid
	private Long idAutor;
	@NotNull
	//@ExistsId(targetClass = Categoria.class, fieldName = "id")
	@Valid
	private Long idCategoria;
	
	public LivrosDTO(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int paginas,
			@NotBlank String isbn, @NotNull @Valid Long idAutor, @NotNull @Valid Long idCategoria) {
		
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}


		
	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}
	

	public Livro toModel(EntityManager manager) {
		
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		Assert.state(Objects.nonNull(autor), "Autor não pode ser nulo.");
		Assert.state(Objects.nonNull(categoria), "Categoria não pode ser nulo.");
		
		
		
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn,
				publicacao, autor, categoria); 
		
	}
	

}
