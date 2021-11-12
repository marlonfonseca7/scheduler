package com.service.scheduler.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.service.scheduler.enums.Status;

@Entity
public class Cliente {

	//Declaração de atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate nascimento;
	private String sexo;
	private String telefone;
	private String telAlternativo;
	private String email;
	
	//private Endereco endereco;
	// @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)//EAGER - ou -LAZY
    //private List<Endereco> enderecos;
	
	@Enumerated(EnumType.ORDINAL) // para gravar no banco o índice(começa com zero) e não o nome
	@Column(columnDefinition = "smallint")
	private Status status;
	
	@OneToMany (mappedBy = "cliente")
	private List<Agenda> agendas;
	
	
	//Declaração de Métodos

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

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelAlternativo() {
		return telAlternativo;
	}

	public void setTelAlternativo(String telAlternativo) {
		this.telAlternativo = telAlternativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	
	
}
