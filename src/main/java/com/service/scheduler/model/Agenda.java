package com.service.scheduler.model;

import javax.persistence.EmbeddedId;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.service.scheduler.enums.Status;
import com.service.scheduler.model.AgendaKey;
import com.service.scheduler.model.Cliente;

public class Agenda {

	@EmbeddedId
	private AgendaKey agendaKey;

    @Enumerated(EnumType.ORDINAL) // para gravar no banco o índice(começa com zero) e não o nome
    private Status status;
	
	@ManyToOne
	@JoinColumn(name="cliente", referencedColumnName = "id")
	private Cliente cliente;

	public Agenda(AgendaKey agendaKey, Status status, Cliente cliente) {
		super();
		this.agendaKey = agendaKey;
		this.status = status;
		this.cliente = cliente;
	}
}
