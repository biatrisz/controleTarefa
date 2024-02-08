package com.ProjetoControleTarefa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoControleTarefa.entitie.Tarefa;
import com.ProjetoControleTarefa.repository.tarefaRepository;

@Service
public class tarefaService {
	private final tarefaRepository tarefaRepository;
	@Autowired
	public tarefaService (tarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	public List<Tarefa> getAllTarefa (){
		return tarefaRepository.findAll();
	}
	public Tarefa getTarefaById(Long id) {
		Optional<Tarefa> Tarefa = tarefaRepository.findById(id);
		return Tarefa.orElse(null);
	}
	public Tarefa salvarTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	public Tarefa updateTarefa(Long id, Tarefa updatedTarefa) {
		Optional<Tarefa> existingTarefa = tarefaRepository.findById(id);
		if (existingTarefa.isPresent()) {
			updatedTarefa.setId(id);
			return tarefaRepository.save(updatedTarefa);
		}
		return null;
	}
	public boolean deleteTarefa(Long id) {
		Optional<Tarefa> existingTarefa = tarefaRepository.findById(id);
		if (existingTarefa.isPresent()) {
			tarefaRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
