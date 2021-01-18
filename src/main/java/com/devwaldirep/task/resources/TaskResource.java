package com.devwaldirep.task.resources;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devwaldirep.task.model.Tasks;
import com.devwaldirep.task.repository.TaskRepository;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("http://localhost:4200")
public class TaskResource {

	
	@Autowired
	private TaskRepository repository;
	
	
	
	@PostMapping
	public Tasks save(@RequestBody Tasks task) {
		
		return repository.save(task);
	}
	
	
	/**
	 * @PathVariable -> pega o Id da tela e coloca dentro do -> Long id
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	public Tasks getById(@PathVariable Long id) {
		
		return repository
				.findById(id) // retorna uma instancia de optional que dentro pode ter ou não um objeto
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // Senão encontrar a tarefa pelo ID vai retorna esse erro -> ResponseStatusException, com status HttpStatus.NOT_FOUND (erro 404)
	}
	
	
	
	@GetMapping
	public List<Tasks> findAll(){
		
		return repository.findAll();
	}
	
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		
		repository.deleteById(id);
	}
	
	
	
	/**
	 * Atualiza a tarefa para feito e coloca a data e hora do ocorrido
	 * findById() -> retorna um optional
	 * @param id
	 * @return
	 * 
	 * A URL fica assim = http://localhost:8080/api/tasks/1/done
	 */
	@PatchMapping("{id}/done") // Marca o metodo para o verbo patch - faz uma atualização parcial em um recurso
	public Tasks markAsDone(@PathVariable Long id) {
		
		return repository.findById(id).map(task -> {
			task.setDone(true);
			task.setDoneDate(LocalDateTime.now());
			repository.save(task);
			return task;
		}).orElse(null); // Não sera lançado nenhum erro
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
