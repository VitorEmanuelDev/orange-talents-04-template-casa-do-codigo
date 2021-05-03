package com.casa_do_codigo.estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lista")
public class EstadoController {
	
	@PersistenceContext
	private EntityManager manager;

		
	@PostMapping(value = "/estados")
	@Transactional
	 public ResponseEntity<NovoEstadoResponse> create(@RequestBody @Valid NovoEstadoRequest request){
	   		
		EstadoModel estado = request.toModel(manager);
		manager.persist(estado);
		return ResponseEntity.ok(new NovoEstadoResponse(estado));
	
		
	}
}