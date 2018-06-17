package com.mvinovacao.cadastro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  name;
	private Object  value;
	
	public NotFoundException(String name, Object value) {
		super(String.format("%s  %s Não encontrado", name,value));
		
		this.setName(name);
		this.setValue(value);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
	
	
	
	

}
