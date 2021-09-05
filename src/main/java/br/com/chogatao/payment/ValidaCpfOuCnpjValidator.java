package br.com.chogatao.payment;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

 @Component
public class ValidaCpfOuCnpjValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return CompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CompraRequest request = (CompraRequest) target;
		if(!request.documentoValido()) {
			errors.rejectValue("Documento", null, "documento precisa ser cpf ou cnpj");
		}
		
	}

}
