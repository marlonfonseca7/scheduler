package com.service.scheduler.model;

import com.service.scheduler.enums.Status;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
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
	private CalendarioProfissionalKey calendarioProfissionalKey;
	
	//@ManyToOne
	//@JoinColumn(name="profissional")
	//private Profissional profissional;
	
	@Enumerated(EnumType.ORDINAL) // para gravar no banco o índice(começa com zero) e não o nome
	 @Column(columnDefinition = "smallint")
	private Status status;
	
	public CalendarioProfissional() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CalendarioProfissional(CalendarioProfissionalKey calendarioProfissionalKey, Status status) {
		super();
		this.calendarioProfissionalKey = calendarioProfissionalKey;
		this.status = status;
	}



	public CalendarioProfissionalKey getCalendarioProfissional() {
		return calendarioProfissionalKey;
	}

	public void setCalendarioProfissional(CalendarioProfissionalKey calendarioProfissionalKey) {
		this.calendarioProfissionalKey = calendarioProfissionalKey;
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
		return Objects.hash(calendarioProfissionalKey);
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
		return Objects.equals(calendarioProfissionalKey, other.calendarioProfissionalKey);
	}



}
