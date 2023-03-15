package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Employe;

public interface IEmployeService {
	// Les méthodes
	List<Employe> findAll();

	Employe findOne(Long id);

	Employe save(Employe employe);

	void delete(Long id);

}
