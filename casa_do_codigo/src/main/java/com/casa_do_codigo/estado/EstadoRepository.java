package com.casa_do_codigo.estado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {

	Optional<EstadoModel> findByNome(String nome);
	
}