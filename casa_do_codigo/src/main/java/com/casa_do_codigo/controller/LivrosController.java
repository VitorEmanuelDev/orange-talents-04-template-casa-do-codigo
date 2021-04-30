package com.casa_do_codigo.controller;

import javax.persistence.*;
import javax.validation.Valid;

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
			
	@PostMapping(value = "/livros")
	@Transactional
	public String create(@Valid @RequestBody LivrosDTO request){
   		
		Livro livro = request.toModel(manager);
		manager.persist(livro);
		return livro.toString();
	
	}
		

}