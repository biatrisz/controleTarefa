package com.ProjetoControleTarefa.entitie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="tarefa")
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "dataFinalExecucao")
	private String dataFinalExecucao;
	
	@Column(name = "descricaoTarefa")
	private String descricaoTarefa;
	
	@Column(name = "statusTarefa")
	private String statusTarefa;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getdataFinalExecucao() {
		return dataFinalExecucao;
	}
	public void setdataFinalExecucao(String dataFinalExecucao) {
		this.dataFinalExecucao = dataFinalExecucao;
	}
	public String getdescricaoTarefa() {
		return descricaoTarefa;
	}
	public void setdescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa= descricaoTarefa;
	}
	public String getstatusTarefa() {
		return statusTarefa;
	}
	public void setstatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

}
