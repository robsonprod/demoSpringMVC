package com.demomvc.dao;

import java.time.LocalDate;
import java.util.List;

import com.demomvc.domain.Funcionario;

public interface FuncionarioDaoInter {

	void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();
    
    List<Funcionario> findByNome(String nome);
    
    List<Funcionario> findByDataEntradaSaida(LocalDate entrada, LocalDate saida);
    
    List<Funcionario> findByDataEntrada(LocalDate entrada);
    
    List<Funcionario> findByDataSaida(LocalDate saida);
	
}
