package com.casa_do_codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.casa_do_codigo.model.Autor;
import com.casa_do_codigo.validator.proibeEmailDuplicadoAutorValidator;


@RestController
@RequestMapping("/lista")
public class AutoresController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private proibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	
	@InitBinder
	public void init(WebDataBinder binder) {
		
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
		
	}
		
	@PostMapping(value = "/post")
	@Transactional
	public String create(@RequestBody @Validated @NotBlank NovoAutorRequest request){
	   		
		Autor autor = request.toModel();
		manager.persist(autor);
		return autor.toString();
	
	}
		

}