package com.financiera.modelos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="solicitudes")
public class Solicitud {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
	@Column private Date fecha;
	@Column private float monto;
	@Column private int cuotas;
	@Column	private String estado;
	@Column private String personaDni;
	
	public Solicitud() { }
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Integer getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPersonaDni() {
		return personaDni;
	}

	public void setPersonaDni(String personaDni) {
		this.personaDni = personaDni;
	}


}
