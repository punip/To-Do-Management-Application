package com.gl.todo.service;

import java.util.List;

import com.gl.todo.dto.TodoDTO;

public interface TodoService {

	TodoDTO createTodo(TodoDTO todoDTO);
	TodoDTO getTodoById(int id);
	TodoDTO updateTodoById(TodoDTO todoDTO,int id);
	List<TodoDTO> getAllTodos();
	void deleteTodoById(int id);
	TodoDTO completeTodo(int id);
	TodoDTO inCompleteTodo(int id);
} 
