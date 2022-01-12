package com.financiera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.financiera.interfaces.PersonaInterface;
import com.financiera.modelos.Persona;

@CrossOrigin
@RestController("solicitudes")
public class PersonaController {
	
	@Autowired
	private PersonaInterface personaInter;
	@PostMapping("/agregar")
	public void agregar(@RequestBody Persona persona) {
		personaInter.save(persona);
	}
	@GetMapping("/listar")
	public List<Persona> listar() {
		return personaInter.findAll();
	}
	@GetMapping("/buscar/{numero}")
	public Persona buscar(@PathVariable("dni") String dni) {
		return personaInter.findById(dni).get();
	}
}

