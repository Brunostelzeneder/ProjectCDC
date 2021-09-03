package br.com.chogatao.genericValidator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.chogatao.model.Estado;
import br.com.chogatao.repository.EstadoRepository;


@Component
public class EstadoDuplicado implements Validator {
	
	@Autowired
	EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Estado.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		Estado request = (Estado) target;
		Optional<Estado> estadoCadastrado = estadoRepository.findBynomeEstado(request.getNomeEstado());
		if(estadoCadastrado.isPresent()) {
			errors.rejectValue("Estado: ", null, "Já cadastrado no sistema: " + request.getNomeEstado());
		}
	}

}
