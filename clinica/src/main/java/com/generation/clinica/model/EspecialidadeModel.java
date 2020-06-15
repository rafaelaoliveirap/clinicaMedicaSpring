package com.generation.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table (name = "tbEspecialidade")

public class EspecialidadeModel {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoEspecialidade;
	
	@Column(name = "nomeEspecialidade", nullable = false)
	@Size (min=3, max=50)
	private String nomeEspecialidade;

	public long getCodigoEspecialidade() {
		return codigoEspecialidade;
	}

	public void setCodigoEspecialidade(long codigoEspecialidade) {
		this.codigoEspecialidade = codigoEspecialidade;
	}

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}
}
