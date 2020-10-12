package com.sbstudentsdata.model.validation;

import java.lang.annotation.*;


import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
@Constraint(validatedBy = DateFormatValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFormat {
	
	String message() default "Invalid Date of Birth.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	
	

}
