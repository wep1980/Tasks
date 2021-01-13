package com.devwaldirep.anotacao.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity // Anotacao do pacote JPA
@Getter
@Setter
public class Tasks {
	
	
	@Id // Anotacao do pacote JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	// Coluna que indica se a tarefa foi cumprida ou não
	@Column
	private boolean done;
	
	@Column
	private LocalDateTime createdDate;
	
	// Marca a data e a hora que a tarefa foi feita
	@Column
	private LocalDateTime doneDate;

}
