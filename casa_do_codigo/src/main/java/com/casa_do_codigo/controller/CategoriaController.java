package com.casa_do_codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.casa_do_codigo.dto.CategoriaDto;
import com.casa_do_codigo.model.Categoria;
//import com.casa_do_codigo.validator.proibeCategoriaDuplicadoAutorValidator;



@RestController
@RequestMapping("/lista")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;
	/*@Autowired
	private proibeCategoriaDuplicadoAutorValidator proibeCategoriaDuplicadoAutorValidator;
	
	
	@InitBinder
	public void init(WebDataBinder binder) {
		
		binder.addValidators(proibeCategoriaDuplicadoAutorValidator);
		
	}*/
		
		
	@PostMapping(value = "/categorias_post")
	@Transactional
	public String create(@RequestBody @Validated @NotBlank CategoriaDto request){
	   		
		Categoria novaCategoria = new Categoria(request.getNome());
		manager.persist(novaCategoria);
		return novaCategoria.toString();
	
	
	}
		

}