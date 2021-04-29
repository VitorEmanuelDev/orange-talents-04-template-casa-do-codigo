package com.casa_do_codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;

import com.casa_do_codigo.dto.CategoriaDTO;
import com.casa_do_codigo.model.Categoria;


@RestController
@RequestMapping("/lista")
public class CategoriasController {
	
	@PersistenceContext
	private EntityManager manager;
		
	@PostMapping(value = "/categorias")
	@Transactional
	public String create(@RequestBody @Valid @NotBlank CategoriaDTO request){
	   		
		Categoria novaCategoria = new Categoria(request.getNome());
		manager.persist(novaCategoria);
		return novaCategoria.toString();
	
	
	}
		

}