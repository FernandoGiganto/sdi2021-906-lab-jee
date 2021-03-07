package com.uniovi.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uniovi.entities.Professor;

@Component
public class ProfessorFormValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Professor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Professor professor = (Professor) target;
		
		if (professor.getName().length() < 5 || professor.getName().length() > 24) {
			errors.rejectValue("name", "Error.signup.name.length");
		}
		if (professor.getSurname().length() < 5 || professor.getSurname().length() > 24) {
			errors.rejectValue("surname", "Error.signup.lastName.length");
		}
		if(professor.getCategory().length() < 3) {
			errors.rejectValue("category", "Error.empty");
		}
		
	}

}
