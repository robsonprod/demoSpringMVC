package com.demomvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demomvc.domain.Cargo;

@Repository
public interface CargoDaoInter {

	void save(Cargo cargo);

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();
	
}
