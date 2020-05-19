package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ToDo;

@Repository
public interface ToDoDAO extends JpaRepository<ToDo, Integer> {

	//@Query
	//public List<ToDo> findByTodoFirstNameContaining(String todoFirstName);
	
	
}
