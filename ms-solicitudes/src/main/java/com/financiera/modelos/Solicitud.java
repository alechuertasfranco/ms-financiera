package com.financiera.modelos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="solicitudes")
public class Solicitud {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer numero;
	@Column private Date fecha;
	@Column private Float monto;
	@Column private Integer cuotas;
	@Column	private String estado;
	// @ManyToOne
    // @JoinColumn(name="id_persona", nullable=false)
    // Persona persona;
	
	public Solicitud() { }
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public Integer getCuotas() {
		return cuotas;
	}
	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	// public Persona getPersona() {
	// 	return persona;
	// }
	// public void setPersona(Persona persona) {
	// 	this.persona = persona;
	// }

}
