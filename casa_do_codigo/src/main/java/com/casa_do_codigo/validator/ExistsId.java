package com.casa_do_codigo.validator;

import javax.validation.*;
import java.lang.annotation.*;


@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExistsIdValidator.class})
public @interface ExistsId {
	
    Class<?> targetClass();

    String fieldName();
    String message() default "Já existe valor para o campo {0}";
    
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}