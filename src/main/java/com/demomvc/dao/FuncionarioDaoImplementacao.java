package com.demomvc.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demomvc.domain.Funcionario;

@Repository
public class FuncionarioDaoImplementacao extends AbstractDao<Funcionario, Long> implements FuncionarioDaoInter{

	@Override
	public List<Funcionario> findByNome(String nome) {
		
		return createQuery("SELECT f FROM Funcionario f WHERE f.nome LIKE concat('%', ?1, '%') ", nome);
	}

	public List<Funcionario> findByCargoId(Long id) {

		return createQuery("SELECT f FROM Funcionario f WHERE f.cargo.id = ?1", id);
	}

	@Override
	public List<Funcionario> findByDataEntradaSaida(LocalDate entrada, LocalDate saida) {

		String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
				.append("WHERE f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("ORDER BY f.dataEntrada asc")
				.toString();
		
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Funcionario> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
				.append("WHERE f.dataEntrada = ?1 ")
				.append("ORDER BY f.dataEntrada asc")
				.toString();
		
		return createQuery(jpql, entrada);
	}

	@Override
	public List<Funcionario> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
				.append("WHERE f.dataSaida = ?1 ")
				.append("ORDER BY f.dataSaida asc")
				.toString();
		
		return createQuery(jpql, saida);
	}

}
