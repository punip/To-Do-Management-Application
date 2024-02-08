package com.gl.todo.mapper;

import com.gl.todo.dto.TodoDTO;
import com.gl.todo.entity.Todo;

public class TodoMapper {

	public static TodoDTO mapToTodoDTO(Todo todo) {
		
		TodoDTO todoDTO = new TodoDTO(
				todo.getId(),
				todo.getTodoTitle(),
				todo.getTodoDescription(),
				todo.isTodoCompleted());
		return todoDTO;
	}
	
	public static Todo mapToTodo(TodoDTO todoDTO) {
		Todo todo = new Todo(
			todoDTO.getId(),
			todoDTO.getTodoTitle(),
			todoDTO.getTodoDescription(),
			todoDTO.isTodoCompleted());
		return todo;
	}
}
