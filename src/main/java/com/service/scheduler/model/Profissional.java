package com.service.scheduler.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.service.scheduler.enums.Status;

@Entity
public class Profissional {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	//private Endereco endereco;
	private LocalDate nascimento;
	private String sexo;
	private String telefone;
	private String telAlternativo;
	private String email;
	
	@Enumerated(EnumType.ORDINAL) // para gravar no banco o índice(começa com zero) e não o nome
    private Status status;
	
	@OneToMany(mappedBy = "calendarioProfissional.profissional") 	// , fetch = FetchType.LAZY) 	Nem faz diferença pra recursividade
	private List<CalendarioProfissional> calendarioProfissionais;	
	
	public Profissional() {
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
//	public Endereco getEndereco() {
//		return endereco;
//	}
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}
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

	public List<CalendarioProfissional> getCalendarioProfissionais() {
		return calendarioProfissionais;
	}

	public void setCalendarioProfissionais(List<CalendarioProfissional> calendarioProfissionais) {
		this.calendarioProfissionais = calendarioProfissionais;
	}
	
	
	
	
	
}