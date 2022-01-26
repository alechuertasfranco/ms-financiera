package com.financiera.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.financiera.feignclients.SolicitudFeignClient;
import com.financiera.interfaces.PersonaInterface;
import com.financiera.modelos.Persona;
import com.financiera.modelos.Solicitud;

@Service
public class PersonaService {
	
	@Autowired
	PersonaInterface personaInterface;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	SolicitudFeignClient solicitudFeignClient;
	
	public List<Persona> getAll() {
		return personaInterface.findAll();
	}
	
	public Persona getPersonaByDni(String dni) {
		return personaInterface.findById(dni).get();
	}
	
	public Persona save(Persona persona) {
		Persona personaNew = personaInterface.save(persona);
		return personaNew;
	}
	
	public List<Solicitud> getSolicitudes(String personaDni) {
		List<Solicitud> solicitudes = restTemplate.getForObject("http://ms-solicitudes/api/solicitudes/persona/"+ personaDni, List.class);
		return solicitudes;
	}
	
	public Solicitud saveSolicitud(String personaDni, Solicitud solicitud) {
		solicitud.setPersonaDni(personaDni);
		Solicitud solicitudNew = solicitudFeignClient.save(solicitud);
		return solicitudNew;
	}
	
	public Map<String, Object> getPersonaSolicitudes(String personaDni) {
		Map<String, Object> result = new HashMap<>();
		Persona persona = personaInterface.findById(personaDni).orElse(null);
		if (persona == null) {
			result.put("Mensaje", "No existe la persona");
			return result;
		}
		result.put("Persona", persona);
		List<Solicitud> solicitudes = solicitudFeignClient.getSolicitudes(personaDni);
		if (solicitudes.isEmpty())
			result.put("Solciitudes", "La persona no tiene solicitudes");
		else
			result.put("Solicitudes", solicitudes);
		return result;
	}
}
