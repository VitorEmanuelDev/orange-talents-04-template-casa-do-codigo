package com.casa_do_codigo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_do_codigo.model.Autor;


@Repository
public interface AutoresRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);
	
}