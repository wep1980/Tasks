package com.devwaldirep.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devwaldirep.task.model.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long>{

}
