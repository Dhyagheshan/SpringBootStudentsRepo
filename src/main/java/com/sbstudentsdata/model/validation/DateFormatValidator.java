package com.sbstudentsdata.model.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateFormatValidator implements 
ConstraintValidator<DateFormat, String> {
	
	@Override
    public void initialize(DateFormat dateFormat) {
	}
 
    @Override
    public boolean isValid(String dateField,
      ConstraintValidatorContext cxt) {
    	
       boolean resp=false;
       try {
    	   DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
           LocalDate dateFormatted=LocalDate.parse(dateField,format);
    	   if(dateField.length()!=10) {
    		   resp=false;
    	   }
    	   System.out.println(dateFormatted);
    	   if(dateField.length()==10 && dateFormatted.isBefore(LocalDate.now().minusYears(5)) && dateFormatted.isAfter(LocalDate.now().minusYears(50))) {
    		   resp=true;
    	   }
       }

       catch(Exception e) {
    	   resp=false;
       }
       return resp;
        
    }
    

}
