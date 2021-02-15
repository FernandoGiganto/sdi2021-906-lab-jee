package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;

@Service
public class ProfessorsService {

	private List<Professor> professorList = new LinkedList<Professor>();

	@PostConstruct
	public void init() {
		professorList.add(new Professor(1L, "fer", "giganto", "sdi"));
		professorList.add(new Professor(2L, "ignacio", "garcia", "asw"));
	}

	public void addProfesor(Professor p) {
		if (p.getId() == null)
			p.setId(professorList.get(professorList.size() - 1).getId() + 1);
		professorList.add(p);
	}

	public Professor getProfesor(Long id) {
		return professorList.stream().filter(professor -> professor.getId().equals(id)).findFirst().get();
	}

	public void deleteProfesor(Long id) {
		professorList.removeIf(professor -> professor.getId().equals(id));
	}

	public List<Professor> getProfessors() {
		return professorList;

	}

}
