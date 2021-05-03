package com.casa_do_codigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.util.Assert;

import com.casa_do_codigo.autor.AutorModel;
import com.casa_do_codigo.categoria.CategoriaModel;
//import com.casa_do_codigo.validator.ExistsId;
import com.casa_do_codigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;



public class NovoLivroRequest {

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
    //@ExistsId(targetClass = ClienteModel.class, fieldName = "id")
	@Valid
	private Long idAutor;
	@NotNull
	//@ExistsId(targetClass = CategoriaModel.class, fieldName = "id")
	@Valid
	private Long idCategoria;
	
	public NovoLivroRequest(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int paginas,
			@NotBlank String isbn, @NotNull @Valid Long idAutor, @NotNull @Valid Long idCategoria) {
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
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



	public Long getIdAutor() {
		return idAutor;
	}



	public Long getIdCategoria() {
		return idCategoria;
	}



	/*Set necessário para contonar erro de construção acionado pelo jackson*/
	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}
	

	public LivroModel toModel(EntityManager manager) {
		
		@NotNull AutorModel autor = manager.find(AutorModel.class, idAutor);
		@NotNull CategoriaModel categoria = manager.find(CategoriaModel.class, idCategoria);
		
		Assert.state(Objects.nonNull(autor), "Autor não pode ser nulo.");
		Assert.state(Objects.nonNull(categoria), "Categoria não pode ser nulo.");
		
		return new LivroModel(titulo, resumo, sumario, preco, paginas, isbn,
				publicacao, autor, categoria); 
		
	}
	

}
