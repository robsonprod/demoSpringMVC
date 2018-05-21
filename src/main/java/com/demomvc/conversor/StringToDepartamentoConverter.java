package com.demomvc.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.demomvc.domain.Departamento;
import com.demomvc.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento>{

	@Autowired
	private DepartamentoService service;
	
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		System.out.println("converter uma string para departamento -> text -> " + text);
		Long id = Long.valueOf(text);
		System.out.println("converter uma string para departamento -> id -> " + id);
		
		return service.buscaPorId(id);
	}

}
