package com.service.scheduler.model;

import com.service.scheduler.enums.Status;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class CalendarioProfissional implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CalendarioProfissionalKey calendarioProfissional;
	
	//@ManyToOne
	//@JoinColumn(name="profissional")
	//private Profissional profissional;
	
	@Enumerated(EnumType.ORDINAL) // para gravar no banco o índice(começa com zero) e não o nome
    private Status status;
	
	public CalendarioProfissional() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CalendarioProfissional(CalendarioProfissionalKey calendarioProfissional, Status status) {
		super();
		this.calendarioProfissional = calendarioProfissional;
		this.status = status;
	}



	public CalendarioProfissionalKey getCalendarioProfissional() {
		return calendarioProfissional;
	}

	public void setCalendarioProfissional(CalendarioProfissionalKey calendarioProfissional) {
		this.calendarioProfissional = calendarioProfissional;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	//Método HashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(calendarioProfissional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarioProfissional other = (CalendarioProfissional) obj;
		return Objects.equals(calendarioProfissional, other.calendarioProfissional);
	}



}
