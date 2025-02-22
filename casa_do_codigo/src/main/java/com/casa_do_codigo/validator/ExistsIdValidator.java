package com.casa_do_codigo.validator;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object>{

	private String domain;
	private Class<?> objeto;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(ExistsId constraintAnnotation) {
		domain = constraintAnnotation.fieldName();
		objeto = constraintAnnotation.targetClass();
		}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " + objeto.getName() + " where " + domain + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.isTrue(list.size() <=1, "Há mais de um" + objeto + "com o atributo" + domain + "contendo o valor =" + value );
		return !list.isEmpty();
		
		

	}

}