package com.example.demo.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="vehiculo")
@JsonIgnoreProperties()
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehiculo")
	@SequenceGenerator(name = "seq_vehiculo", sequenceName = "seq_vehiculo", allocationSize = 1)
	@Column(name = "vehi_id")
	private Integer id;
	
	
	@Column(name = "vehi_placa")
	private String placa;
	
	
	@Column(name = "vehi_numero_puerta")
	private Integer numeroPuerta;
	
	
	@Column(name = "vehi_gasolina")
	private Double gasolina;
	
	
	@Column(name = "vehi_tipo")
	private String tipo;


	//SET y GET
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public Integer getNumeroPuerta() {
		return numeroPuerta;
	}


	public void setNumeroPuerta(Integer numeroPuerta) {
		this.numeroPuerta = numeroPuerta;
	}


	public Double getGasolina() {
		return gasolina;
	}


	public void setGasolina(Double gasolina) {
		this.gasolina = gasolina;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}
