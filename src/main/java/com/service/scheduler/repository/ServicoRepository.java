package com.service.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.scheduler.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
