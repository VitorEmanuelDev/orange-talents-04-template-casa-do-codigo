package com.casa_do_codigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.casa_do_codigo.autor.AutorModel;
import com.casa_do_codigo.categoria.CategoriaModel;

@Entity
@Table(name = "LivrosDB")
public class LivroModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @NotBlank String sumario;
	private @NotNull @Min(20) BigDecimal preco;
	private @Min(100) int paginas;
	private @NotBlank String isbn;
	@NotNull
	private @Future LocalDate publicacao;
	@ManyToOne
	private @NotNull @Valid AutorModel autor;
	@ManyToOne
	private @NotNull @Valid CategoriaModel categoria;
	
	
	@Deprecated
	public LivroModel() {
		
	}


	public LivroModel(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int paginas,
			@NotBlank String isbn, @Future @NotNull LocalDate publicacao,
			@NotNull @Valid AutorModel autor, @NotNull @Valid CategoriaModel categoria) {

		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.publicacao = publicacao;
		this.autor = autor;
		this.categoria = categoria;
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


	public AutorModel getAutor() {
		return autor;
	}


	public CategoriaModel getCategoria() {
		return categoria;
	}


}

