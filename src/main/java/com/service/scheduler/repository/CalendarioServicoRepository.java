package com.service.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.scheduler.model.CalendarioServico;
import com.service.scheduler.model.CalendarioServicoKey;

@Repository
public interface CalendarioServicoRepository extends JpaRepository<CalendarioServico, CalendarioServicoKey> {

}
