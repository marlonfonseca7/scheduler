package com.service.scheduler.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CalendarioServicoKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="servico", referencedColumnName = "id")
	private Servico servico;
	private LocalDate data;
	// aplicar Timestamp	> https://dzone.com/articles/storing-java-8-localdatetime-as-timestamp-postgres
	private LocalTime horaInicial;
	private LocalTime horaFinal;
	
	public CalendarioServicoKey() {
		// TODO Auto-generated constructor stub
	}	
	
	

	public CalendarioServicoKey(Servico servico, LocalDate data, LocalTime horaInicial, LocalTime horaFinal) {
		super();
		this.servico = servico;
		this.data = data;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}


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
		CalendarioServicoKey other = (CalendarioServicoKey) obj;
		return Objects.equals(data, other.data) && Objects.equals(horaFinal, other.horaFinal)
				&& Objects.equals(horaInicial, other.horaInicial) && Objects.equals(servico, other.servico);
	}


	
}


