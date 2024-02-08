package com.ProjetoControleTarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoControleTarefa.entitie.Tarefa;
import com.ProjetoControleTarefa.service.tarefaService;

import jakarta.validation.Valid;
@RestController
@RequestMapping ("/tarefa")
public class tarefaController {
private tarefaService tarefaService;
	
	@Autowired
	public tarefaController(tarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscaTarefaControlId(@PathVariable Long id){
		Tarefa tarefa = tarefaService.getTarefaById(id);
		if (tarefa != null) {
			return ResponseEntity.ok(tarefa);
		}
		else {
			return ResponseEntity.notFound().build();		
		}

	}
	@GetMapping
	public ResponseEntity<List<Tarefa>>buscaTodosTarefaControl(){
		List <Tarefa> Tarefa = tarefaService.getAllTarefa();
		return ResponseEntity.ok(Tarefa);
	}
	@PostMapping
	public ResponseEntity<Tarefa> salvaTarefaControl(@RequestBody @Valid Tarefa tarefa){
		Tarefa salvaTarefa = tarefaService.salvarTarefa(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa);
	}
		@PutMapping("/{id}")
		public ResponseEntity<Tarefa> alteraTarefaControl(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
			Tarefa alteraTarefa = tarefaService.updateTarefa(id, tarefa);
			if(alteraTarefa != null) {
				return ResponseEntity.ok(tarefa);
			}
			else {
				return ResponseEntity.notFound().build();
			}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Tarefa> apagaTarefaControl(@PathVariable  Long id){
		boolean apagar = tarefaService.deleteTarefa(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
