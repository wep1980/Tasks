package com.devwaldirep.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {
	
	
	
	/*@Autowired
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
		
	}*/
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
