package com.casa_do_codigo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_do_codigo.model.Categoria;
import com.casa_do_codigo.model.Livro;

@Repository
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findByNome(String nome);

	
}