package com.stefanini.todolist.service;

import com.stefanini.todolist.model.Todo;
import org.springframework.stereotype.Service;

@Service
public interface TarefaService {
    Todo criarNovoTodo(Todo todoDto) throws RuntimeException;
}
