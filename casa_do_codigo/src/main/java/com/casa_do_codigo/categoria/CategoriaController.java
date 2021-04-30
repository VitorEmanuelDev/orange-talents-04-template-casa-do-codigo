package com.casa_do_codigo.categoria;

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
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;
		
	@PostMapping(value = "/categorias")
	@Transactional
	public ResponseEntity<NovaCategoriaResponse> create(@RequestBody @Valid NovaCategoriaRequest request){
	   		
		CategoriaModel categoria = request.toModel();
		manager.persist(categoria);
		return ResponseEntity.ok(new NovaCategoriaResponse(categoria));
	
	}
		

}