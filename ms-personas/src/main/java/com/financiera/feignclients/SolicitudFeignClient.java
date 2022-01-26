package com.financiera.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.financiera.modelos.Solicitud;

@FeignClient(name="ms-solicitudes", path = "/api/solicitudes")
public interface SolicitudFeignClient {
	
	@PostMapping()
	Solicitud save(@RequestBody Solicitud solicitud);
	
	@GetMapping("persona/{personaDni}")
	List<Solicitud> getSolicitudes(@PathVariable("personaDni") String personaDni);
}
