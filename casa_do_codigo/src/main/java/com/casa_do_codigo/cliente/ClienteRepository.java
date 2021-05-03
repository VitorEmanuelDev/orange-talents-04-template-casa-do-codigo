package com.casa_do_codigo.cliente;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

	Optional<ClienteModel> findById(Long id);
		
}