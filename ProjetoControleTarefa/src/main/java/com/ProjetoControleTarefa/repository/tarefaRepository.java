package com.ProjetoControleTarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoControleTarefa.entitie.Tarefa;

public interface tarefaRepository extends JpaRepository<Tarefa, Long>{

}
