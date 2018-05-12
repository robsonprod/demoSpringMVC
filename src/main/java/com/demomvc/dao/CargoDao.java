package com.demomvc.dao;

import org.springframework.stereotype.Repository;

import com.demomvc.domain.Cargo;

@Repository
public class CargoDao extends AbstractDao<Cargo, Long> implements CargoDaoInter{

}
