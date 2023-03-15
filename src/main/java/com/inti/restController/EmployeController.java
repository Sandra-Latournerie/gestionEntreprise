package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Employe;
import com.inti.service.interfaces.IEmployeService;

@RestController
public class EmployeController {
	@Autowired
	IEmployeService employeService;

	@GetMapping("/employes")
	public List<Employe> findAll() {
		return employeService.findAll();
	}

	@GetMapping("/employes/{idEmploye}")
	public Employe findOne(@PathVariable("idEmploye") Long id) {
		return employeService.findOne(id);
	}

	@PostMapping("/employes")
	public Employe saveemploye(@RequestBody Employe employe) {
		return employeService.save(employe);
	}

	@DeleteMapping("/employes/{idEmploye}")
	public void deleteemploye(@PathVariable("idEmploye") Long id) {
		employeService.delete(id);
	}

	@PutMapping("/employes/{idEmploye}")
	public Employe updateEmploye(@PathVariable("idEmploye") Long id, @RequestBody Employe employe) {

		Employe currentUser = employeService.findOne(id);

		currentUser.setNomEmploye(employe.getNomEmploye());
		currentUser.setPrenomEmploye(employe.getPrenomEmploye());

		return employeService.save(currentUser);
	}
}
