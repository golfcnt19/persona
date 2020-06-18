package com.persona.persona;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService service;
	
	@GetMapping("/persona")
	public List<Persona> list() {
		return service.listAll();
	}
	
	@GetMapping("/persona/{id}")
	public ResponseEntity<Persona> get(@PathVariable Integer id) {
	    try {
	    	Persona persona = service.get(id);
	        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/persona")
	public void add(@RequestBody Persona persona) {
		service.save(persona);
	}
	
	@PutMapping("/persona/{id}")
	public ResponseEntity<?> update(@RequestBody Persona persona, @PathVariable Integer id) {
	    try {
	        @SuppressWarnings("unused")
	        Persona existProduct = service.get(id);
	        service.save(persona);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	@DeleteMapping("/persona/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}

	

}
