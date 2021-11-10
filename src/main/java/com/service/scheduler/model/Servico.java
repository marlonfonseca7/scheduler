package com.service.scheduler.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.scheduler.enums.Status;

@Entity
public class Servico implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private  String nome;
	private int duracao;
	private Double preco;
	
	// Gera no MySQL um TINYBLOB - campo blob de armazenamento máximo igual a 255 caracteres (8 bits) mais 1 de controle;
	//private Enum<Status> status;
	
	@Enumerated(EnumType.ORDINAL) // para gravar no banco o índice(começa com zero) e não o nome
    private Status status;
	
	@OneToMany(mappedBy = "calendarioServico.servico") 	// , fetch = FetchType.LAZY) 	Nem faz diferença pra recursividade
	// from : https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
	//@JsonManagedReference 	// Mostra o Fornecedor e todos seus Produtos - Usar somente em List
	//@JsonIgnore 				// Mostra somente o Fornecedor
	private List<CalendarioServico> calendarioServico;	
	
	@OneToMany(mappedBy = "calendarioProfissional.servico") 	// , fetch = FetchType.LAZY) 	Nem faz diferença pra recursividade
	private List<CalendarioProfissional> calendarioProfissionais;		
	
	public Servico() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public List<CalendarioServico> getCalendarioServico() {
		return calendarioServico;
	}

	public void setCalendarioServico(List<CalendarioServico> calendarioServico) {
		this.calendarioServico = calendarioServico;
	}

	public List<CalendarioProfissional> getCalendarioProfissionais() {
		return calendarioProfissionais;
	}

	public void setCalendarioProfissionais(List<CalendarioProfissional> calendarioProfissionais) {
		this.calendarioProfissionais = calendarioProfissionais;
	}




}
