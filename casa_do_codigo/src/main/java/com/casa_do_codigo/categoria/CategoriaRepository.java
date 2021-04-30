package com.casa_do_codigo.categoria;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_do_codigo.livro.LivroModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	Optional<CategoriaModel> findByNome(String nome);

	
}