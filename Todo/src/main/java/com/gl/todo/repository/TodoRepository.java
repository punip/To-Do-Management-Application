package com.gl.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
