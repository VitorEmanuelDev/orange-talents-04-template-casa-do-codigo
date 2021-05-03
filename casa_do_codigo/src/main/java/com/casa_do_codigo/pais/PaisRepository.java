package com.casa_do_codigo.pais;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisModel, Long> {

	Optional<PaisModel> findByNome(String nome);
	
}