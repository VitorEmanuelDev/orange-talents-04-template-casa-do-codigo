package com.casa_do_codigo.controller;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.casa_do_codigo.dto.LivrosDTO;
import com.casa_do_codigo.model.Livro;


@RestController
@RequestMapping("/lista")
public class LivrosController {
	
	@PersistenceContext
	private EntityManager manager;
			
	@PostMapping(value = "/livros", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	//@ResponseBody
	public ResponseEntity<Livro> create(@RequestBody @Valid @NotBlank LivrosDTO request){
   		
		Livro livro = request.toModel(manager);
		manager.persist(livro);
		livro.toString();
		return ResponseEntity.ok().build();
	
	
	}
		

}