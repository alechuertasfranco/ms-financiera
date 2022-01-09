package com.financiera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.financiera.interfaces.SolicitudInterface;
import com.financiera.modelos.Solicitud;

@CrossOrigin
@RestController("solicitudes")
public class SolicitudController {
	
	@Autowired
	private SolicitudInterface solicitudInter;
	@PostMapping("/agregar")
	public ResponseEntity<Solicitud> agregar(@RequestBody Solicitud soli) {
		solicitudInter.save(soli);
		return new ResponseEntity<Solicitud>(HttpStatus.OK);
	}
	@GetMapping("/listar")
	public List<Solicitud> listar() {
		return solicitudInter.findAll();
	}
	@GetMapping("/buscar/{numero}")
	public Solicitud buscar(@PathVariable("numero") Integer numero) {
		return solicitudInter.findById(numero).get();
	}
	@PutMapping("/aprobar/{numero}")
	public String aprobar(@PathVariable("numero") Integer numero) {
		solicitudInter.aprobarSolicitud(numero);
		return "Aprobado";
	}
	@PutMapping("/rechazar/{numero}")
	public String rechazar(@PathVariable("numero") Integer numero) {
		solicitudInter.rechazarSolicitud(numero);
		return "Rechazado";
	}
}

