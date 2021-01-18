package com.devwaldirep.task.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private Boolean done;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createdDate;
	
	// Marca a data e a hora que a tarefa foi feita
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime doneDate;
	
	
	
	/**
	 * Metodo que salva a data e a hora no momento em que a tarefa e criada
	 * Esse metodo e executado antes de salvar no BD
	 */
	@PrePersist
	public void beforeSave() {
		
		setCreatedDate(LocalDateTime.now());
	}

}
