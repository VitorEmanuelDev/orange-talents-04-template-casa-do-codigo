package com.casa_do_codigo.validator;

import java.lang.annotation.*;

import javax.validation.*;

import com.casa_do_codigo.model.Livro;


@Documented
@Constraint(validatedBy = { UniqueValueValidator.class })
@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
	
	String message() default "{com.casa_do_codigo.validator.UniqueValue}";
	
	Class<?>[] groups() default {};
		
	Class<? extends Payload>[] payload() default {};

	String fieldName();

	Class<?> targetClass();

}
