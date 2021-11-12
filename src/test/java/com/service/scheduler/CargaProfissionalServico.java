package com.service.scheduler;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.scheduler.model.Profissional;
import com.service.scheduler.model.Servico;
import com.service.scheduler.repository.ProfissionalRepository;
import com.service.scheduler.repository.ServicoRepository;

@SpringBootTest
class CargaProfissionalServico {

	@Autowired
	ServicoRepository sr;

	@Autowired
	ProfissionalRepository pr;

	@Test
	void contextLoads() {
	}

	@Test
	void cargaServicoProfissional() {

	//Carga de Serviços
		
		Servico s1 = new Servico();
		s1.setNome("Barba");
		s1.setDuracao(30);
		s1.setPreco(15.0);
		sr.save(s1);

		Servico s2 = new Servico();
		s2.setNome("Cabelo");
		s2.setDuracao(60);
		s2.setPreco(25.0);
		sr.save(s2);

		Servico s3 = new Servico();
		s3.setNome("Bigode");
		s3.setDuracao(30);
		s3.setPreco(10.0);
		sr.save(s3);

		Servico s4 = new Servico();
		s4.setNome("COMBO Completo");
		s4.setDuracao(120);
		s4.setPreco(40.0);
		sr.save(s4);		

		
	//Carga de Profissionais
		
		Profissional p1 = new Profissional();
		p1.setNome("Reinaldo");
		p1.setEmail("reinaldofsoares@xpto.com.br");
		p1.setNascimento(LocalDate.of(2002, 10, 21));
		p1.setSexo("M");
		p1.setTelefone("21994762826");
		pr.save(p1);

		Profissional p2 = new Profissional();
		p2.setNome("Jonatas");
		p2.setEmail("jonsilva@ypto.com.br");
		p2.setNascimento(LocalDate.of(2000, 05, 13));
		p2.setSexo("M");
		p2.setTelefone("21992084576");
		pr.save(p2);

		Profissional p3 = new Profissional();
		p3.setNome("Fábio");
		p3.setEmail("fabioramos@zpto.com.br");
		p3.setNascimento(LocalDate.of(1999, 9, 10));
		p3.setSexo("M");
		p3.setTelefone("219847465745");		
		pr.save(p3);

	}

}
