package com.gl.todo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.todo.dto.TodoDTO;
import com.gl.todo.entity.Todo;
import com.gl.todo.exception.ResourceNotFoundException;
import com.gl.todo.mapper.TodoMapper;
import com.gl.todo.repository.TodoRepository;
import com.gl.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public TodoDTO createTodo(TodoDTO todoDTO) {
		Todo todo = TodoMapper.mapToTodo(todoDTO);
		return TodoMapper.mapToTodoDTO(todoRepository.save(todo));
	}

	@Override
	public TodoDTO getTodoById(int id) {
		Todo t = null;
		t = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo does not exist with the given id " + id));
		return TodoMapper.mapToTodoDTO(t);
	}

	@Override
	public TodoDTO updateTodoById(TodoDTO todoDTO, int id) {
		Todo t = null;
		t = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo does not exist with the given id " + id));
		t.setTodoTitle(todoDTO.getTodoTitle());
		t.setTodoDescription(todoDTO.getTodoDescription());
		t.setTodoCompleted(todoDTO.isTodoCompleted());
		todoRepository.save(t);
		return TodoMapper.mapToTodoDTO(t);
	}

	@Override
	public List<TodoDTO> getAllTodos() {
		List<Todo> list = todoRepository.findAll();
		return list.stream().map((todo) -> TodoMapper.mapToTodoDTO(todo)).collect(Collectors.toList());
	}

	@Override
	public void deleteTodoById(int id) {
		Todo t = null;
		t = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo does not exist with the given id " + id));
		todoRepository.deleteById(id);
	}

	@Override
	public TodoDTO completeTodo(int id) {
		Todo t = null;
		t = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo does not exist with the given id " + id));
		t.setTodoCompleted(true);
		 todoRepository.save(t);
		 return TodoMapper.mapToTodoDTO(t);
	}

	@Override
	public TodoDTO inCompleteTodo(int id) {
		Todo t = null;
		t = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo does not exist with the given id " + id));
		t.setTodoCompleted(false);
		 todoRepository.save(t);
		return TodoMapper.mapToTodoDTO(t);
	}

}
