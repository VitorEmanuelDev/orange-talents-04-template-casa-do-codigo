package com.casa_do_codigo.pais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lista")
public class PaisController {
	
	@PersistenceContext
	private EntityManager manager;

		
	@PostMapping(value = "/paises")
	@Transactional
	 public ResponseEntity<NovoPaisResponse> create(@RequestBody @Valid NovoPaisRequest request){
	   		
		PaisModel pais = request.toModel();
		manager.persist(pais);
		return ResponseEntity.ok(new NovoPaisResponse(pais));
	
		
	}
}