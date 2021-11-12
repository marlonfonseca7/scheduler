package com.service.scheduler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.scheduler.enums.Status;
import com.service.scheduler.model.CalendarioProfissional;
import com.service.scheduler.model.CalendarioProfissionalKey;
import com.service.scheduler.model.CalendarioServico;
import com.service.scheduler.model.CalendarioServicoKey;
import com.service.scheduler.model.Profissional;
import com.service.scheduler.model.Servico;
import com.service.scheduler.repository.CalendarioProfissionalRepository;
import com.service.scheduler.repository.CalendarioServicoRepository;
import com.service.scheduler.repository.ProfissionalRepository;
import com.service.scheduler.repository.ServicoRepository;

@SpringBootTest
class AgendaApplicationTests {

	@Autowired
	ServicoRepository sr;
	
	@Autowired
	CalendarioServicoRepository csr;

	@Autowired
	ProfissionalRepository pr;

	@Autowired
	CalendarioProfissionalRepository cpr;	

	
	
	@Test
	void contextLoads() {
	}

	@Test
	void cargaCalendarioServicoBarba() {

		// Serviço 1-BARBA
		Optional<Servico> o1 = sr.findById(1L);
		// if (o1.isPresent()) then		
		Servico s1 = o1.get();

		// 6.6.1 Preservando Instantes de Tempo 		>https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-time-instants.html
		// Converting Between LocalDate and SQL Date 	>https://www.baeldung.com/java-convert-localdate-sql-date

		// HORAS DE BARBA
		LocalDate d1 = LocalDate.of(2021, 10, 14);
		LocalTime hi1 = LocalTime.of(8, 0, 0);
		LocalTime hf1 = LocalTime.of(8, 30, 0);

		LocalTime hi2 = LocalTime.of(8, 30, 0);
		LocalTime hf2 = LocalTime.of(9, 0, 0);

		LocalTime hi3 = LocalTime.of(9, 0, 0);
		LocalTime hf3 = LocalTime.of(9, 30, 0);

		LocalTime hi4 = LocalTime.of(9, 30, 0);
		LocalTime hf4 = LocalTime.of(10, 0, 0);

		CalendarioServicoKey csk1 = new CalendarioServicoKey(s1, d1, hi1, hf1);
		CalendarioServico cs1 = new CalendarioServico(csk1, Status.ATIVO);
		csr.save(cs1);

		CalendarioServicoKey csk2 = new CalendarioServicoKey(s1, d1, hi2, hf2);
		CalendarioServico cs2 = new CalendarioServico(csk2, Status.ATIVO);
		csr.save(cs2);

		CalendarioServicoKey csk3 = new CalendarioServicoKey(s1, d1, hi3, hf3);
		CalendarioServico cs3 = new CalendarioServico(csk3, Status.ATIVO);
		csr.save(cs3);

		CalendarioServicoKey csk4 = new CalendarioServicoKey(s1, d1, hi4, hf4);
		CalendarioServico cs4 = new CalendarioServico(csk4, Status.ATIVO);
		csr.save(cs4);		

	}


	//@Test
	void cargaCalendarioServicoCombo() {

		// Serviço 4-SEJA MAIS (COMBO)
		Optional<Servico> o1 = sr.findById(4L);
		Servico s1 = o1.get();

		// HORAS DE SEJA MAIS
		LocalDate d1 = LocalDate.of(2021, 10, 14);
		LocalTime hi1 = LocalTime.of(8, 0, 0);
		LocalTime hf1 = LocalTime.of(10, 0, 0);

		LocalTime hi2 = LocalTime.of(10, 0, 0);
		LocalTime hf2 = LocalTime.of(12, 0, 0);

		CalendarioServicoKey csk1 = new CalendarioServicoKey(s1, d1, hi1, hf1);
		CalendarioServico cs1 = new CalendarioServico(csk1, Status.ATIVO);
		csr.save(cs1);

		CalendarioServicoKey csk2 = new CalendarioServicoKey(s1, d1, hi2, hf2);
		CalendarioServico cs2 = new CalendarioServico(csk2, Status.ATIVO);
		csr.save(cs2);

	}
	
	//@Test
	void cargaCalendarioProfissional() {

		// Profissional 1-ANA
		Optional<Profissional> op1 = pr.findById(1L);
		Profissional p1 = op1.get();		
		
		// Serviço 1-BARBA
		Optional<Servico> os1 = sr.findById(1L);
		Servico s1 = os1.get();
		// Serviço 2-CABELO
		Optional<Servico> os2 = sr.findById(2L);
		Servico s2 = os2.get();
		// Serviço 3-BIGODE
		Optional<Servico> os3 = sr.findById(3L);
		Servico s3 = os3.get();		
		
		// 6.6.1 Preservando Instantes de Tempo 		>https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-time-instants.html
		// Converting Between LocalDate and SQL Date 	>https://www.baeldung.com/java-convert-localdate-sql-date
		
		LocalDate d1 = LocalDate.of(2021, 10, 14);
		
		// HORAS DE BARBA E BIGODE
		LocalTime hi1 = LocalTime.of(8, 0, 0);
		LocalTime hf1 = LocalTime.of(8, 30, 0);
		
		LocalTime hi2 = LocalTime.of(8, 30, 0);
		LocalTime hf2 = LocalTime.of(9, 0, 0);
		
		LocalTime hi3 = LocalTime.of(9, 0, 0);
		LocalTime hf3 = LocalTime.of(9, 30, 0);
		
		LocalTime hi4 = LocalTime.of(9, 30, 0);
		LocalTime hf4 = LocalTime.of(10, 0, 0);
		
		// CABELO
		LocalTime hi5 = LocalTime.of(8, 0, 0);
		LocalTime hf5 = LocalTime.of(9, 0, 0);
		
		LocalTime hi6 = LocalTime.of(9, 0, 0);
		LocalTime hf6 = LocalTime.of(10, 0, 0);		
		
		
		// 1-BARBA 1-ANA  
		CalendarioProfissionalKey cpk1 = new CalendarioProfissionalKey(s1, d1, hi1, hf1, p1);
		CalendarioProfissional cp1 = new CalendarioProfissional(cpk1, Status.ATIVO);
		cpr.save(cp1);
		
		CalendarioProfissionalKey cpk2 = new CalendarioProfissionalKey(s1, d1, hi2, hf2, p1);
		CalendarioProfissional cp2 = new CalendarioProfissional(cpk2, Status.ATIVO);
		cpr.save(cp2);
		
		CalendarioProfissionalKey cpk3 = new CalendarioProfissionalKey(s1, d1, hi3, hf3, p1);
		CalendarioProfissional cp3 = new CalendarioProfissional(cpk3, Status.ATIVO);
		cpr.save(cp3);

		CalendarioProfissionalKey cpk4 = new CalendarioProfissionalKey(s1, d1, hi4, hf4, p1);
		CalendarioProfissional cp4 = new CalendarioProfissional(cpk4, Status.ATIVO);
		cpr.save(cp4);		
		
		
		// 2-BIGODE 1-ANA  
		CalendarioProfissionalKey cpk11 = new CalendarioProfissionalKey(s3, d1, hi1, hf1, p1);
		CalendarioProfissional cp11 = new CalendarioProfissional(cpk11, Status.ATIVO);
		cpr.save(cp11);
		
		CalendarioProfissionalKey cpk12 = new CalendarioProfissionalKey(s3, d1, hi2, hf2, p1);
		CalendarioProfissional cp12 = new CalendarioProfissional(cpk12, Status.ATIVO);
		cpr.save(cp12);
		
		CalendarioProfissionalKey cpk13 = new CalendarioProfissionalKey(s3, d1, hi3, hf3, p1);
		CalendarioProfissional cp13 = new CalendarioProfissional(cpk13, Status.ATIVO);
		cpr.save(cp13);

		CalendarioProfissionalKey cpk14 = new CalendarioProfissionalKey(s3, d1, hi4, hf4, p1);
		CalendarioProfissional cp14 = new CalendarioProfissional(cpk14, Status.ATIVO);
		cpr.save(cp14);		
		
		
		// 3-CABELO 1-ANA  
		CalendarioProfissionalKey cpk21 = new CalendarioProfissionalKey(s2, d1, hi5, hf5, p1);
		CalendarioProfissional cp21 = new CalendarioProfissional(cpk21, Status.ATIVO);
		cpr.save(cp21);
		
		CalendarioProfissionalKey cpk22 = new CalendarioProfissionalKey(s2, d1, hi6, hf6, p1);
		CalendarioProfissional cp22 = new CalendarioProfissional(cpk22, Status.ATIVO);
		cpr.save(cp22);		

	}
	
}
