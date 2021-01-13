package com.devwaldirep.task.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devwaldirep.task.model.Tasks;
import com.devwaldirep.task.repository.TaskRepository;

@RestController
@RequestMapping("/api/tasks")
public class TaskResource {

	
	@Autowired
	private TaskRepository repository;
	
	
	
	@PostMapping
	public Tasks save(@RequestBody Tasks task) {
		
		return repository.save(task);
	}
	
	
	
	@GetMapping("{id}")
	public Tasks getById(Long id) {
		
		return repository
				.findById(id) // retorna uma instancia de optional que dentro pode ter ou não um objeto
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // Senão encontrar a tarefa pelo ID vai retorna esse erro -> ResponseStatusException, com status HttpStatus.NOT_FOUND (erro 404)
	}
}
