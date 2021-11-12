package com.service.scheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.scheduler.model.CalendarioProfissional;
import com.service.scheduler.model.Servico;
import com.service.scheduler.repository.AgendaRepository;
import com.service.scheduler.repository.CalendarioProfissionalRepository;
import com.service.scheduler.repository.CalendarioServicoRepository;
import com.service.scheduler.repository.ProfissionalRepository;
import com.service.scheduler.repository.ServicoRepository;

@SpringBootTest
class SchedulerOnDemand {
	
	@Autowired
	ServicoRepository sr;
	
	@Autowired
	CalendarioServicoRepository csr;

	@Autowired
	ProfissionalRepository pr;

	@Autowired
	CalendarioProfissionalRepository cpr;	
	
	@Autowired
	AgendaRepository agr;

	@Test
	void test() {
		//fail("Not yet implemented");
	
	}
	
	@Test
	void agendaOnDemand() {
		
		// ONDEMAND 1 - Cliente inicia pesquisa pelo SERVICO e DATA
		
		// SERVICO 1-BARBA
		Optional<Servico> o1 = sr.findById(1L);
		// if (o1.isPresent()) then		
		Servico s1 = o1.get();		
		System.out.println(s1.getNome() + " " + s1.getDuracao());

		// 6.6.1 Preservando Instantes de Tempo 		>https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-time-instants.html
		// Converting Between LocalDate and SQL Date 	>https://www.baeldung.com/java-convert-localdate-sql-date

		// NESTA DATA 
		LocalDate d1 = LocalDate.of(2021, 10, 14);
		
		List<CalendarioProfissional> lcp  = cpr.findServicoData(s1, d1);//, hi1,hf1);
		
		for (CalendarioProfissional cp : lcp) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("Nome : " + cp.getCalendarioProfissional().getServico().getNome());
			System.out.println("Data : " + cp.getCalendarioProfissional().getData().format(dateTimeFormatter));
		}
		
		//Agenda ag1 = new Agenda(ak1, Status.ATIVO, null);
		
		//agr.save(ag1);

		// ONDEMAND 2 - ESCOLHE O HORÁRIO
		LocalDateTime hi1 = LocalDateTime.of(2021, 10, 14, 8, 0, 0);
		LocalDateTime hf1 = LocalDateTime.of(2021, 10, 14, 8, 30, 0);

		
	}

}

