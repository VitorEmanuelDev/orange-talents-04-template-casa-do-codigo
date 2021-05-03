package com.casa_do_codigo.livro;


import java.math.BigDecimal;
import java.time.LocalDate;


import javax.validation.Valid;
import javax.validation.constraints.*;

import com.casa_do_codigo.autor.AutorModel;
import com.casa_do_codigo.categoria.CategoriaModel;
import com.casa_do_codigo.validator.ExistsId;
import com.casa_do_codigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


public class NovoLivroResponse {

	private Long id;
	@NotBlank
	@UniqueValue(targetClass = LivroModel.class,fieldName = "titulo")
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
	@UniqueValue(targetClass = LivroModel.class,fieldName = "isbn")
	private String isbn;
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate publicacao;
	@NotNull
	@ExistsId(targetClass = AutorModel.class, fieldName = "id")
	@Valid
	private AutorModel autor;
	@NotNull
	@ExistsId(targetClass = CategoriaModel.class, fieldName = "id")
	@Valid
	private CategoriaModel categoria;
	
	public NovoLivroResponse(LivroModel livro) {
		
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.publicacao = livro.getPublicacao();
		this.autor = livro.getAutor();
		this.categoria = livro.getCategoria();
		
	}


	public Long getId() {
		return id;
	}	
	
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getPublicacao() {
		return publicacao;
	}

	public AutorModel getIdAutor() {
		return autor;
	}

	public CategoriaModel getIdCategoria() {
		return categoria;
	}


}
