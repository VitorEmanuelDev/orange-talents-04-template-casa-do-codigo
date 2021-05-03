package com.casa_do_codigo.produtos;

import java.util.*;

import javax.persistence.*;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.casa_do_codigo.livro.LivroModel;
import com.casa_do_codigo.livro.LivroRepository;



@RestController
@RequestMapping("/lista")
public class DetalheLivroController {
	
	//@Autowired
	//private  LivroRepository livroRepository; 
	
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping(value = "/livros/{id}")
	public DetalheLivroResponse getById(@PathVariable Long id){ 
		
		LivroModel livro = manager.find(LivroModel.class, id);
		
		if(livro == null){
			
	           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	           
	        }
		
	        return new DetalheLivroResponse(livro);
	}

}