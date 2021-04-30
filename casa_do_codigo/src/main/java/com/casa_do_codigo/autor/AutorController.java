package com.casa_do_codigo.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lista")
public class AutorController {
	
	@PersistenceContext
	private EntityManager manager;

		
	@PostMapping(value = "/autores")
	@Transactional
	 public ResponseEntity<NovoAutorResponse> create(@RequestBody @Valid NovoAutorRequest request){
	   		
		AutorModel autor = request.toModel();
		manager.persist(autor);
		return ResponseEntity.ok(new NovoAutorResponse(autor));
	
	}
		

}