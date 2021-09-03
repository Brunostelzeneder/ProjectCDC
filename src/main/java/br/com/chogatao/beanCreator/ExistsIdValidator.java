package br.com.chogatao.beanCreator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object>

{
	private String domainAttribute;
	private Class<?> klass; 
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(ExistsId params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}




	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
		query.setParameter("value", value);	
		List<?> list = query.getResultList();
		Assert.state(list.size() <=1, "Foi encontrado mais de um "+klass+" com o atributo "+domainAttribute+" = "+ value);
		return list.isEmpty();
	}

}
