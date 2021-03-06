package com.service.scheduler.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CalendarioProfissionalKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="servico", referencedColumnName = "id")
	private Servico servico;
	private LocalDate data;
	private LocalTime horaInicial;
	private LocalTime horaFinal;

	@ManyToOne
	@JoinColumn(name="profissional", referencedColumnName = "id")
	private Profissional profissional;
	
	
	//Método Constructor
	
	public CalendarioProfissionalKey() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CalendarioProfissionalKey(Servico servico, LocalDate data, LocalTime horaInicial, LocalTime horaFinal,
			Profissional profissional) {
		super();
		this.servico = servico;
		this.data = data;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.profissional = profissional;
	}

	//Métodos Get Set


	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}



	public LocalTime getHoraInicial() {
		return horaInicial;
	}



	public void setHoraInicial(LocalTime horaInicial) {
		this.horaInicial = horaInicial;
	}



	public LocalTime getHoraFinal() {
		return horaFinal;
	}



	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}



	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	//Método HashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(data, horaFinal, horaInicial, servico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarioProfissionalKey other = (CalendarioProfissionalKey) obj;
		return Objects.equals(data, other.data) && Objects.equals(horaFinal, other.horaFinal)
				&& Objects.equals(horaInicial, other.horaInicial) && Objects.equals(servico, other.servico);
	}


	
}
