package com.casa_do_codigo.validator;

import java.util.List;

import javax.persistence.*;
import javax.validation.*;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object>{

	private String domain;
	private Class<?> objeto;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(UniqueValue constraintAnnotation) {
		
		domain = constraintAnnotation.fieldName();
		objeto = constraintAnnotation.targetClass();
		
		}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " + objeto.getName() + " where " + domain + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <=1, "Existe mais de um " + objeto + " com o mesmo valor.");
		return list.isEmpty();
	}

}