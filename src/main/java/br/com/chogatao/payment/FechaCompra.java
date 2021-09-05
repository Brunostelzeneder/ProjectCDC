package br.com.chogatao.payment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chogatao.genericValidator.EstadoPertencePais;

@RestController
@RequestMapping("carrinho")
public class FechaCompra {
	
	
	@Autowired
	EstadoPertencePais estadoPertencePais;
	
//	@InitBinder
//	public void estadoPais(WebDataBinder binder) {
//		binder.addValidators();
//	}
	
	

	@InitBinder
	public void validaCPFOuCNPJ(WebDataBinder binder) {
		binder.addValidators(new ValidaCpfOuCnpjValidator(),estadoPertencePais);
		
	}
	
	@PostMapping("compra")
	public String fechaCOmpra(@RequestBody @Valid CompraRequest request) {
		
		
		return request.toString();
	}

	


}
