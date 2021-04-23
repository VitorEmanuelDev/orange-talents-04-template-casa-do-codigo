package com.casa_do_codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.casa_do_codigo.model.Autor;


@RestController
@RequestMapping("/lista")
public class AutoresController {
	
	@PersistenceContext
	private EntityManager manager;
		
	@PostMapping(value = "/post")
	@Transactional
	public String create(@RequestBody @Validated @NotBlank NovoAutorRequest request){
	   		
		Autor autor = request.toModel();
		manager.persist(autor);
		return autor.toString();
	
	}
		

}