package com.gl.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.todo.dto.TodoDTO;
import com.gl.todo.entity.Todo;
import com.gl.todo.service.TodoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@PostMapping
	ResponseEntity<TodoDTO> createTodo(@RequestBody TodoDTO todoDTO){
		TodoDTO t = todoService.createTodo(todoDTO);
		return new ResponseEntity(t,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	ResponseEntity<TodoDTO> getTodoById(@PathVariable("id") int id){
		TodoDTO t = todoService.getTodoById(id);
		return new ResponseEntity(t,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	ResponseEntity<TodoDTO> updateTodoById(@RequestBody TodoDTO todoDTO,@PathVariable("id") int id){
		TodoDTO t = todoService.updateTodoById(todoDTO, id);
		return new ResponseEntity(t,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<TodoDTO> deleteTodoById(@PathVariable("id") int id){
		todoService.deleteTodoById(id);
		return new ResponseEntity("Todo deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity<List<TodoDTO>> getAllTodos(){
		List<TodoDTO> list = todoService.getAllTodos();
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	@PatchMapping("{id}/complete")
	ResponseEntity<TodoDTO> completeTodo(@PathVariable("id") int id){
		TodoDTO t = todoService.completeTodo(id);
		return new ResponseEntity(t,HttpStatus.OK);
	}
	
	@PatchMapping("{id}/incomplete")
	ResponseEntity<TodoDTO> InCompleteTodo(@PathVariable("id") int id){
		TodoDTO t = todoService.inCompleteTodo(id);
		return new ResponseEntity(t,HttpStatus.OK);
	}
	
	
}
