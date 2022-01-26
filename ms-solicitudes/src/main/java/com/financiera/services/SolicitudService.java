package com.financiera.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financiera.interfaces.SolicitudInterface;
import com.financiera.modelos.Solicitud;

@Service
public class SolicitudService {
	@Autowired
	SolicitudInterface solicitudInterface;
	
	public List<Solicitud> getAll() {
		return solicitudInterface.findAll();
	}
	
	public Solicitud getSolicitudById(int id) {
		return solicitudInterface.findById(id).get();
	}
	
	public Solicitud save(Solicitud solicitud) {
		Solicitud solicitudNew = solicitudInterface.save(solicitud);
		return solicitudNew;
	}
	

	public String aprobarSolicitud(int id) {
		solicitudInterface.aprobarSolicitud(id);
		return "Aprobado";
	}
	
	public String rechazarSolicitud(int id) {
		solicitudInterface.rechazarSolicitud(id);
		return "Rechazado";
	}
	
	public List<Solicitud> byPersonaDni(String personaDni) {
		return solicitudInterface.findByPersonaDni(personaDni);
	}

}
