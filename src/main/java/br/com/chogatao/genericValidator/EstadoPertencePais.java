package br.com.chogatao.genericValidator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.chogatao.model.Estado;
import br.com.chogatao.model.Pais;
import br.com.chogatao.payment.CompraRequest;

@Component
public class EstadoPertencePais implements Validator {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return CompraRequest.class.isAssignableFrom	(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		
		CompraRequest request = (CompraRequest) target;
		Pais pais = manager.find(Pais.class, request.getIdPais());
		Estado estado = manager.find(Estado.class, request.getIdEstado());
		
		if(!estado.pertenceAPais(pais)) {
			errors.rejectValue("idEstado: ", null, " Não pertence ao pais selecionado");
		}
		
		
	}
	
	

}
