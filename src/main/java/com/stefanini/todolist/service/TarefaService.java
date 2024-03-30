package com.stefanini.todolist.service;

import com.stefanini.todolist.exception.ResourceAlreadyExistsException;
import com.stefanini.todolist.exception.ResourceNotFoundException;
import com.stefanini.todolist.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface TarefaService {
    Todo criarNovoTodo(Todo todoDto) throws ResourceAlreadyExistsException;

    Todo buscarTodo(Integer id) throws ResourceNotFoundException;

    Page<Todo> buscarTodos(Pageable pageable);

    Todo alterarTodo(Integer id, Todo newTodo) throws ResourceNotFoundException;

    void deletarTodo(Integer id) throws ResourceNotFoundException;
}
