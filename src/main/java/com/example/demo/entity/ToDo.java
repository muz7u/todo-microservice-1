package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name="todo")
public class ToDo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="todo_id")
	private int todoId;
	
	@Column(name="todo_first_name")
	private String todoFirstName;
	
	@Column(name="todo_last_name")
	private String todoLastName;

	@Column(name="todo_email")
	private String todoEmail;

	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDo(String todoFirstName, String todoLastName, String todoEmail) {
		super();
		this.todoFirstName = todoFirstName;
		this.todoLastName = todoLastName;
		this.todoEmail = todoEmail;
	}

	
	
}
