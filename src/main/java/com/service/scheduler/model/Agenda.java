package com.service.scheduler.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.service.scheduler.enums.Status;

@Entity
public class Agenda {

	@EmbeddedId
	private AgendaKey agendaKey;

    @Enumerated(EnumType.ORDINAL) // para gravar no banco o índice(começa com zero) e não o nome
    @Column(columnDefinition = "smallint")
    private Status status;
	
	@ManyToOne
	@JoinColumn(name="cliente", referencedColumnName = "id")
	private Cliente cliente;

	
	//Método Constructor
	
	public Agenda(AgendaKey agendaKey, Status status, Cliente cliente) {
		super();
		this.agendaKey = agendaKey;
		this.status = status;
		this.cliente = cliente;
		
	//Métodos Get e Set
		
	}

	public AgendaKey getAgendaKey() {
		return agendaKey;
	}

	public void setAgendaKey(AgendaKey agendaKey) {
		this.agendaKey = agendaKey;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	//Método HashCode
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendaKey == null) ? 0 : agendaKey.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (agendaKey == null) {
			if (other.agendaKey != null)
				return false;
		} else if (!agendaKey.equals(other.agendaKey))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
}
