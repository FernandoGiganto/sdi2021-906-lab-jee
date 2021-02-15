package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorsService;

@RestController
public class ProfessorsController {

	@Autowired // Inyectar el servicio
	private ProfessorsService professorService;

	@RequestMapping("/professor/list")
	public String getList() {
		return professorService.getProfessors().toString();
	}

	@RequestMapping(value = "/professor/add", method = RequestMethod.POST)
	public String setProfessor(@ModelAttribute Professor p) {
		professorService.addProfesor(p);
		return "Ok";
	}

	@RequestMapping("/professor/details/{id}")
	public String getDetail( @PathVariable Long id) {
		return professorService.getProfesor(id).toString();
	}

	@RequestMapping("/professor/delete/{id}")
	public String deleteMark(@PathVariable Long id) {
		professorService.deleteProfesor(id);
		return "Ok";
	}

	

}
