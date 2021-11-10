package com.service.scheduler.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.scheduler.model.Agenda;
import com.service.scheduler.model.AgendaKey;
import com.service.scheduler.model.Cliente;


@Repository
public interface AgendaRepository extends JpaRepository<Agenda, AgendaKey> {

	Optional<Agenda> findByCliente(Cliente cliente);

}
