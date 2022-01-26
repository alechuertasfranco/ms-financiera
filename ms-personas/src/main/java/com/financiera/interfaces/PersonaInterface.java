package com.financiera.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.financiera.modelos.Persona;

@Transactional
@Repository
public interface PersonaInterface extends JpaRepository<Persona, String>{
}
