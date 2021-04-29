package com.casa_do_codigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casa_do_codigo.model.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

	Optional<Livro> findByTitulo(String titulo);
	Optional<Livro> findByIsbn(String isbn);
	
}