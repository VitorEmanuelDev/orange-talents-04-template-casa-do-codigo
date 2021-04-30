package com.casa_do_codigo.autor;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Long> {

	Optional<AutorModel> findByEmail(String email);
	
}