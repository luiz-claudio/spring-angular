package com.mvinovacao.cadastro.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mvinovacao.cadastro.model.Cadastro;
import com.mvinovacao.cadastro.resources.CadastroResouce;

public class CadastroValidate implements Validator {

	@Autowired
	private CadastroResouce cadastroResouce;

	@Override
	public boolean supports(Class<?> clazz) {

		return Cadastro.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Cadastro cadastro = (Cadastro) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login vazio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email vazio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "senha vazia");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "nome vazio");

		if (cadastroResouce.findBylogin(cadastro.getLogin()) != null) {
			errors.rejectValue("login", "Login duplicado");
		}

		if (cadastroResouce.findByemail(cadastro.getEmail()) != null
				|| cadastroResouce.findBylogin(cadastro.getEmail()) != null) {
			errors.rejectValue("email", "E-mail duplicado");

		}

	}

}
