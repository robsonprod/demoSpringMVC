package com.demomvc.dao;

import org.springframework.stereotype.Repository;

import com.demomvc.domain.Funcionario;

@Repository
public class FuncionarioDao extends AbstractDao<Funcionario, Long> implements FuncionarioDaoInter{

}
