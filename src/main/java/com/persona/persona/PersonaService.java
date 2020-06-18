package com.persona.persona;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class PersonaService {

	@Autowired
	private PersonaRepository repo;
	
	public List<Persona> listAll() {
		return repo.findAll();
	}
	
	public void save(Persona persona) {
        repo.save(persona);
    }
     
    public Persona get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
