package com.stefanini.todolist.service.impl;

import com.stefanini.todolist.config.Messages;
import com.stefanini.todolist.exception.ResourceAlreadyExistsException;
import com.stefanini.todolist.exception.ResourceNotFoundException;
import com.stefanini.todolist.model.Todo;
import com.stefanini.todolist.repository.TodoRepository;
import com.stefanini.todolist.service.TarefaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private Messages messages;

    private TodoRepository todoRepository;

    @Override
    public Todo criarNovoTodo(Todo todo) throws ResourceAlreadyExistsException {

        Optional<Todo> existingTodo = todoRepository.findByTitulo(todo.getTitulo());

       if(existingTodo.isPresent()){
           throw new ResourceAlreadyExistsException(messages.get("exception.todo.alreadyExists"));
       }
       todo.setAtualizadoEm(LocalDateTime.now());
       todo.setCriadoEm(LocalDateTime.now());

       return todoRepository.save(todo);

    }

    @Override
    public Todo buscarTodo(Integer id) throws ResourceNotFoundException {

        Optional<Todo> todo = todoRepository.findById(id);

        if(todo.isPresent()){
            return todo.get();
        } else {
            throw new ResourceNotFoundException(messages.get("exception.todo.notFound"));
        }
    }

    @Override
    public Page<Todo> buscarTodos(Pageable pageable) {

        Page<Todo> todos = todoRepository.findAll(pageable);

        return todos;
    }

    @Override
    public Todo alterarTodo(Integer id, Todo newTodo) throws ResourceNotFoundException {

        Optional<Todo> todo = todoRepository.findById(id);

        if(todo.isPresent()){
            newTodo.setId(todo.get().getId());
            newTodo.setCriadoEm(todo.get().getCriadoEm());
            newTodo.setAtualizadoEm(LocalDateTime.now());

            return todoRepository.save(newTodo);
        } else {
            throw new ResourceNotFoundException(messages.get("exception.todo.notFound"));
        }

    }

    @Override
    public void deletarTodo(Integer id) throws ResourceNotFoundException {
        Optional<Todo> todo = todoRepository.findById(id);

        if(todo.isPresent()) {
            todoRepository.delete(todo.get());
        } else {
            throw new ResourceNotFoundException(messages.get("exception.todo.notFound"));
        }
    }
}
