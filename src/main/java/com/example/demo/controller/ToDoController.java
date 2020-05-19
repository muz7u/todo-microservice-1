package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ToDoDAO;
import com.example.demo.entity.ToDo;

@RestController
@RequestMapping("/api")
public class ToDoController {

	private ToDoDAO todoDAO;

	@Autowired
	public ToDoController(ToDoDAO todoDAO) {
		super();
		this.todoDAO = todoDAO;
	}
	
	
	@GetMapping("/tod")
	public List<ToDo> findAllToDo()
	{
		return todoDAO.findAll();
	}
	
	@GetMapping("/tod/{id}")
	public ToDo findToDoByToDoId(@PathVariable("id") Integer id)
	{
		return todoDAO.findById(id).get();
	}
	
	@PostMapping("/tod")
	public ToDo addToDo(@RequestBody ToDo objToDo)
	{
		todoDAO.save(objToDo);
		return objToDo;
	}
	
	@PutMapping("/tod/{id}")
	public ResponseEntity<ToDo> updateEmployee(@PathVariable(value = "id") Integer todoId, @RequestBody ToDo objToDo)
	{
		ToDo todo=todoDAO.findById(todoId).get();
		todo.setTodoFirstName(objToDo.getTodoEmail());
		todo.setTodoLastName(objToDo.getTodoLastName());
		todo.setTodoEmail(objToDo.getTodoEmail());
		final ToDo updatedToDo=todoDAO.save(todo);
		return ResponseEntity.ok(updatedToDo);
	}
	
	
	
	@DeleteMapping("/tod/{id}")
	public void deleteById(@PathVariable("id") Integer id)
	{
		ToDo objToDo=findToDoByToDoId(id);
		todoDAO.delete(objToDo);
	}
	
	/*
	@GetMapping("/tod/findByName")
	public List<ToDo> findToDoByName(@RequestParam String name)
	{
		return todoDAO.findByTodoFirstNameContaining(name);
	}
	*/
	
	
}
