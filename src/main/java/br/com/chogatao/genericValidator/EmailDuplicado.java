package br.com.chogatao.genericValidator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.chogatao.model.Autor;
import br.com.chogatao.repository.AutorRepository;

@Component
public class EmailDuplicado implements Validator {
	
	@Autowired
	AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Autor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		Autor request = (Autor) target;
		Optional <Autor> emailCadastrado = autorRepository.findByEmail(request.getEmail());
		
		if(emailCadastrado.isPresent()) {
			errors.rejectValue("Email ", null, " já cadastrado!" + request.getEmail());
		}
	}
	
	

}
