package com.financiera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financiera.modelos.Solicitud;
import com.financiera.services.SolicitudService;

@CrossOrigin
@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {
	
	@Autowired
	SolicitudService solicitudService;
	
	@GetMapping
	public ResponseEntity<List<Solicitud>> getAll() {
		List<Solicitud> solicitudes = solicitudService.getAll();
		if(solicitudes.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(solicitudes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Solicitud> getById(@PathVariable("id") int id) {
		Solicitud solicitud = solicitudService.getSolicitudById(id);
		if(solicitud == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(solicitud);
	}

	@PostMapping
	public ResponseEntity<Solicitud> save(@RequestBody Solicitud solicitud) {
		Solicitud solicitudNew = solicitudService.save(solicitud);
		return ResponseEntity.ok(solicitudNew);
	}
	
	@PutMapping("/aprobar/{id}")
	public String aprobar(@PathVariable("id") int id) {
		return solicitudService.aprobarSolicitud(id); 
	}
	
	@PutMapping("/rechazar/{id}")
	public String rechazar(@PathVariable("id") int id) {
		return solicitudService.rechazarSolicitud(id);
	}

	@GetMapping("/persona/{personaDni}")
	public ResponseEntity<List<Solicitud>> getByPersonaDni(@PathVariable("personaDni") String personaDni) {
		List<Solicitud> solicitudes = solicitudService.byPersonaDni(personaDni);
		if(solicitudes.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(solicitudes);
	}
	
}

