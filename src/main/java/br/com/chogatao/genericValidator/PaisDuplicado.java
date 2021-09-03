package br.com.chogatao.genericValidator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.chogatao.model.Pais;
import br.com.chogatao.repository.PaisRepository;


@Component
public class PaisDuplicado implements Validator {
	
	@Autowired
	PaisRepository paisRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Pais.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		Pais request = (Pais) target;
		Optional<Pais> paisCadastrado = paisRepository.findBynomePais(request.getNomePais());
		if(paisCadastrado.isPresent()) {
			errors.rejectValue("Pais: ", null, " Já cadastrado no sistema " + request.getNomePais());
		}
	}

}
