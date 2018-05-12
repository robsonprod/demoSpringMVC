package com.demomvc.dao;

import java.util.List;

import com.demomvc.domain.Funcionario;

public interface FuncionarioDaoInter {

	void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();
	
}
