package br.com.chogatao.genericValidator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.chogatao.model.Categoria;
import br.com.chogatao.repository.CategoriaRepository;

@Component
public class CategoriaDuplicada implements Validator {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Categoria.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		Categoria request = (Categoria) target;
		Optional <Categoria> categoriaCadastrada = categoriaRepository.findByNomeCategoria(request.getNomeCategoria());
		if(categoriaCadastrada.isPresent()) {
			errors.rejectValue("Categoria", null, " Já cadastrada" + request.getNomeCategoria());
		}
	}
	
	

}
