package com.casa_do_codigo.livro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long>{

	Optional<LivroModel> findById(Long id);
	Optional<LivroModel> findByTitulo(String titulo);
	Optional<LivroModel> findByIsbn(String isbn);
	
}