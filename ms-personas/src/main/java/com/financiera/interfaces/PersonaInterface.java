package com.financiera.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.financiera.modelos.Persona;

@Transactional
public interface PersonaInterface extends JpaRepository<Persona, String>{
}
