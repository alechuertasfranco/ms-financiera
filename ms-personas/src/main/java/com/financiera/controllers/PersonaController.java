package com.financiera.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financiera.modelos.Persona;
import com.financiera.modelos.Solicitud;
import com.financiera.services.PersonaService;

@CrossOrigin
@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping
	public ResponseEntity<List<Persona>> getAll() {
		List<Persona> personas = personaService.getAll();
		if(personas.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(personas);
	}

	@GetMapping("/{dni}")
	public ResponseEntity<Persona> getById(@PathVariable("dni") String dni) {
		Persona persona = personaService.getPersonaByDni(dni);
		if(persona == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(persona);
	}

	@PostMapping
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		Persona personaNew = personaService.save(persona);
		return ResponseEntity.ok(personaNew);
	}
	
	@GetMapping("/solicitudes/{personaDni}")
	public ResponseEntity<List<Solicitud>> getSolicitudes(@PathVariable("personaDni") String personaDni) {
		Persona persona = personaService.getPersonaByDni(personaDni);
		if(persona == null)
			return ResponseEntity.notFound().build();
		List<Solicitud> solicitudes = personaService.getSolicitudes(personaDni);
		return ResponseEntity.ok(solicitudes);
	}

	
	@PostMapping("/savesolicitud/{personaDni}")
	public ResponseEntity<Solicitud> saveSolicitud(@PathVariable("personaDni") String personaDni, @RequestBody Solicitud solicitud) {
		if(personaService.getPersonaByDni(personaDni) == null)
			return ResponseEntity.notFound().build();
		Solicitud solicitudNew = personaService.saveSolicitud(personaDni, solicitud);
		return ResponseEntity.ok(solicitudNew);
	}
	
	@GetMapping("/getAll/{personaDni}")
	public ResponseEntity<Map<String, Object>> getAllSolicitudes(@PathVariable("personaDni") String personaDni) {
		Map<String, Object> result = personaService.getPersonaSolicitudes(personaDni);
		return ResponseEntity.ok(result);
	}
}

