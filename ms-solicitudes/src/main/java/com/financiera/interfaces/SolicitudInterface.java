package com.financiera.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.financiera.modelos.Solicitud;

@Repository
@Transactional
public interface SolicitudInterface extends JpaRepository<Solicitud, Integer>{
	
	@Modifying
	@Query(value="UPDATE solicitudes SET estado='A' WHERE id=:id", nativeQuery = true)
	void aprobarSolicitud(@Param("id") int id);

	@Modifying
	@Query(value="UPDATE solicitudes SET estado='D' WHERE id=:id", nativeQuery = true)
	void rechazarSolicitud(@Param("id") int id);
	
	List<Solicitud> findByPersonaDni(String personaDni);
}
