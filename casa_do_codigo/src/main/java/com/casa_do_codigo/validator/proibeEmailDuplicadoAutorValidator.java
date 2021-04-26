package com.casa_do_codigo.validator;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import com.casa_do_codigo.controller.NovoAutorRequest;
import com.casa_do_codigo.model.Autor;
import com.casa_do_codigo.repository.AutoresRepository;


@Component
public class proibeEmailDuplicadoAutorValidator implements Validator{
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	@Override
	public boolean supports(Class<?> classe) {
		
		return NovoAutorRequest.class.isAssignableFrom(classe);
		
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			
			return;
			
		}
		
		NovoAutorRequest request = (NovoAutorRequest) target;
		
		Optional<Autor> possivelAutor = autoresRepository.findByEmail(request.getEmail());
		
		if(possivelAutor.isPresent()) {
			
			errors.rejectValue("email", null, "E-mail já cadastrado:" + request.getEmail());
			
		}
		
	}

}
