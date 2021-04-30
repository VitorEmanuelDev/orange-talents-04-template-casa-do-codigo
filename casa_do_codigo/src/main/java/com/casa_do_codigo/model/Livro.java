package com.casa_do_codigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

//import com.casa_do_codigo.validator.ExistsId;



@Entity
@Table(name = "LivrosDB")
public class Livro {
	

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
	private @NotNull @Valid Autor autor;
	@ManyToOne
	private @NotNull @Valid Categoria categoria;
	
	
	@Deprecated
	public Livro() {
		
	}


	public Livro(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int paginas,
			@NotBlank String isbn, @Future @NotNull LocalDate publicacao,
			@NotNull @Valid Autor autor, @NotNull @Valid Categoria categoria) {
		
		super();
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


	public Integer getPaginas() {
		return paginas;
	}


	public String getIsbn() {
		return isbn;
	}


	public Autor getNomeAutor() {
		return autor;
	}


	public Categoria getNomeCategoria() {
		return categoria;
	}

	

	@Override
	public String toString() {
		
		return "Categoria [ID = " + id + ", Titulo = " + titulo + ", Resumo = "
		        + resumo + ", Sumário = " + sumario + ", Preco = " + preco + 
		        ", Paginas = " + paginas + ", ISBN = " + isbn + ", Publicacao = " + publicacao +
		        ", Autor = " + autor + ", Categoria = " + categoria + " ]";	
		
	}
	
	public LocalDate getPublicacao() {
		return this.publicacao;
	}
	


}

