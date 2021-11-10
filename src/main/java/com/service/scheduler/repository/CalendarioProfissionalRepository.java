package com.service.scheduler.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.scheduler.enums.Status;
import com.service.scheduler.model.CalendarioProfissional;
import com.service.scheduler.model.CalendarioProfissionalKey;
import com.service.scheduler.model.Servico;


@Repository
public interface CalendarioProfissionalRepository extends JpaRepository<CalendarioProfissional, CalendarioProfissionalKey> {

	//List<CalendarioProfissional> 
	List<CalendarioProfissional> findByStatus(Enum<Status> status);
	
	
	Optional<CalendarioProfissional> findById(CalendarioProfissionalKey id);
	
	@Query(value= "select  	cp.* "
			    + "from		calendario_profissional cp "
			    + "where	cp.servico = ?1 and "
			    + "			cp.data = ?2 ", nativeQuery = true )	
	List<CalendarioProfissional> findServicoData(Servico servico, LocalDate data);	
	
	

}
