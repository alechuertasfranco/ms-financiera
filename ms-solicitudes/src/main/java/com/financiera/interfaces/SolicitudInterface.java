package com.financiera.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.financiera.modelos.Solicitud;

@Transactional
public interface SolicitudInterface extends JpaRepository<Solicitud, Integer>{
	@Modifying
	@Query(value="UPDATE solicitudes SET estado='A' WHERE numero=:numero", nativeQuery = true)
	void aprobarSolicitud(@Param("numero") Integer numero);

	@Modifying
	@Query(value="UPDATE solicitudes SET estado='D' WHERE numero=:numero", nativeQuery = true)
	void rechazarSolicitud(@Param("numero") Integer numero);
}
