package com.devwaldirep.task;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.devwaldirep.task.model.Tasks;
import com.devwaldirep.task.repository.TaskRepository;

@SpringBootApplication
public class TaskApplication {
	
	
	
	@Autowired
	private TaskRepository repository;
	
	
	
	// Inicia o codigo ao iniciar o contexto da aplicação
	@Bean
	public CommandLineRunner init() {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Tasks task = new Tasks();
				task.setDescription("teste repository");
				task.setCreatedDate(LocalDateTime.now());
				
				repository.save(task);
			}
		};
		
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
