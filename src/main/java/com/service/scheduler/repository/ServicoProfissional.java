package com.service.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.scheduler.model.Servico;

public interface ServicoProfissional extends JpaRepository<Servico, Long> {

}
