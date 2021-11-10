package com.service.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.scheduler.model.Profissional;


@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

}
