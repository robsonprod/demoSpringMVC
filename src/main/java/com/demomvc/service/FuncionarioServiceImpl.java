package com.demomvc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demomvc.dao.FuncionarioDaoImplementacao;
import com.demomvc.domain.Funcionario;

@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDaoImplementacao dao;
	
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		return dao.findByNome(nome);
	}

	@Override
	public List<Funcionario> buscarPorCargo(Long id) {
		return dao.findByCargoId(id);
	}

	@Override
	public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		if(entrada != null && saida != null) {
			return dao.findByDataEntradaSaida(entrada, saida);
		}else if(entrada != null) {
			return dao.findByDataEntrada(entrada);
		}else if(saida != null) {
			return dao.findByDataSaida(saida);
		}else {
			return new ArrayList<>();
		}
	}

}
