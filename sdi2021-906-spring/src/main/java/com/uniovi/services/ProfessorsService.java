package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;
import com.uniovi.repositories.ProfessorRepository;

@Service
public class ProfessorsService {

	@Autowired 
	private ProfessorRepository professorRepository;


	public void addProfesor(Professor p) {
		professorRepository.save(p);
	}

	public Professor getProfesor(Long id) {
		return professorRepository.findById(id).get();
	}

	public void deleteProfesor(Long id) {
		professorRepository.deleteById(id);
	}

	public List<Professor> getProfessors() {
		List<Professor>  p = new ArrayList<Professor>();
		professorRepository.findAll().forEach(p::add);
		return p;

	}

}
