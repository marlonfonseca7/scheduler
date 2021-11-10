package com.service.scheduler.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.service.scheduler.enums.Status;

@Entity
public class CalendarioServico implements Serializable {
	
	@EmbeddedId
	private CalendarioServicoKey calendarioServico;
	
	@Enumerated(EnumType.ORDINAL) // para gravar no banco o índice(começa com zero) e não o nome
    private Status status;
	
	//Método Constructor
	
	public CalendarioServico() {
		// TODO Auto-generated constructor stub
	
	}

	//Métodos Get e Set
	
	public CalendarioServico(CalendarioServicoKey calendarioServico, Status status) {
		super();
		this.calendarioServico = calendarioServico;
		this.status = status;
	}



	public CalendarioServicoKey getCalendarioServico() {
		return calendarioServico;
	}

	public void setCalendarioServico(CalendarioServicoKey calendarioServico) {
		this.calendarioServico = calendarioServico;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	// Método HashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(calendarioServico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarioServico other = (CalendarioServico) obj;
		return Objects.equals(calendarioServico, other.calendarioServico);
	}



}
