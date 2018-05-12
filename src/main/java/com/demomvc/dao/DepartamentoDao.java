package com.demomvc.dao;

import org.springframework.stereotype.Repository;

import com.demomvc.domain.Departamento;

@Repository
public class DepartamentoDao extends AbstractDao<Departamento, Long> implements DepartamentoDaoInter{

}
