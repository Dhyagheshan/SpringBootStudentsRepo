package com.sbstudentsdata.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class ContactNumValidator implements 
ConstraintValidator<ContactNum, String> {
	
	@Override
    public void initialize(ContactNum contactNum) {
    }
 
    @Override
    public boolean isValid(String contactNumField,
      ConstraintValidatorContext cxt) {
    	
    	boolean resp=false;
    	try {
    		if(StringUtils.isEmpty(contactNumField)) {
        		resp= true;
        	}
    		else if(!StringUtils.isEmpty(contactNumField)) {
    			if((contactNumField != "string" )&& (contactNumField.matches("[0-9]+"))&& ((contactNumField.length() > 8) && (contactNumField.length() < 14))) {
    				resp= true;
    			}    		
        	}
    		else resp= false;
    	}
    	catch(Exception e) {
    		resp= false;
    	} 	
        return resp;
    }

}
