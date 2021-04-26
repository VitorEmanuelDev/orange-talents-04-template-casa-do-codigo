package com.casa_do_codigo.validator;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import com.casa_do_codigo.controller.NovaCategoriaRequest;
import com.casa_do_codigo.model.Categoria;
import com.casa_do_codigo.repository.CategoriaRepository;


@Component
public class proibeCategoriaDuplicadoAutorValidator implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> classe) {
		
		return NovaCategoriaRequest.class.isAssignableFrom(classe);
		
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			
			return;
			
		}
		
		NovaCategoriaRequest request = (NovaCategoriaRequest) target;
		
		Optional<Categoria> possivelAutor = categoriaRepository.findByNome(request.getNome());
		
		if(possivelAutor.isPresent()) {
			
			errors.rejectValue("email", null, "E-mail já cadastrado:" + request.getNome());
			
		}
		
	}

}