package com.casa_do_codigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lista")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;

	 @Autowired
	 private  ClienteRepository clienteRepository; 
		
	@PostMapping(value = "/clientes")
	@Transactional
	public ResponseEntity<NovoClienteResponse> create(@RequestBody @Valid NovoClienteRequest request){
	   		
		ClienteModel cliente = request.toModel(manager);
		clienteRepository.save(cliente);
		return ResponseEntity.ok(new NovoClienteResponse(cliente));
	
	}
		

}