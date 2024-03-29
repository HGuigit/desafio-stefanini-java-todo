package com.stefanini.todolist.service.impl;

import com.stefanini.todolist.model.Todo;
import com.stefanini.todolist.repository.TodoRepository;
import com.stefanini.todolist.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public Todo criarNovoTodo(Todo todo) throws RuntimeException {

        Optional<Todo> existingTodo = todoRepository.findByTitulo(todo.getTitulo());

       if(existingTodo.isPresent()){
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Parece que esse 'todo' já existe.");
       }
       todo.setAtualizadoEm(LocalDateTime.now());
       todo.setCriadoEm(LocalDateTime.now());

       return todoRepository.save(todo);

    }
}
