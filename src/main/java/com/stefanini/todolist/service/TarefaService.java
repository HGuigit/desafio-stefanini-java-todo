package com.stefanini.todolist.service;

import com.stefanini.todolist.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public interface TarefaService {
    Todo criarNovoTodo(Todo todoDto) throws ResponseStatusException;

    Todo buscarTodo(Integer id) throws RuntimeException;

    Page<Todo> buscarTodos(Pageable pageable);

    Todo alterarTodo(Integer id, Todo newTodo) throws RuntimeException;
}
