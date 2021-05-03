package com.casa_do_codigo.livro;

import java.util.*;

import javax.persistence.*;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.casa_do_codigo.produtos.DetalheLivroResponse;



@RestController
@RequestMapping("/lista")
public class LivroController {
	
	@Autowired
	private  LivroRepository livroRepository; 
	
	@PersistenceContext
	private EntityManager manager;
			
	@PostMapping(value = "/livros")
	@Transactional
	public ResponseEntity<NovoLivroResponse> create(@RequestBody @Valid NovoLivroRequest request){
		
	    LivroModel livro = request.toModel(manager);
	    manager.persist(livro);
	    return ResponseEntity.ok(new NovoLivroResponse(livro));
	    
	}
	
	@GetMapping(value = "/livros")
	public ResponseEntity<List<LivroModel>> getAll(){ 
		return ResponseEntity.ok(livroRepository.findAll());
	}
	
	
}