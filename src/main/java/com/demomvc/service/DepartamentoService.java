package com.demomvc.service;

import java.util.List;

import com.demomvc.domain.Departamento;


public interface DepartamentoService {

void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscaPorId(Long id);
	
	List<Departamento> buscarTodos();

	boolean departamentoTemCargos(Long id);
	
}
