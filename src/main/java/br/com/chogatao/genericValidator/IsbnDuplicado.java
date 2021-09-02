package br.com.chogatao.genericValidator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.chogatao.model.Livro;
import br.com.chogatao.repository.LivroRepository;

@Component
public class IsbnDuplicado implements Validator {
	
	@Autowired
	LivroRepository livroRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Livro.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		Livro request = (Livro) target;
		Optional<Livro> isbnDuplicado = livroRepository.findByIsbn(request.getIsbn());
		
		if(isbnDuplicado.isPresent()) {
			errors.reject("Isbn ", null, " já cadastrado no sistema " + request.getIsbn());
		}
	}

}
