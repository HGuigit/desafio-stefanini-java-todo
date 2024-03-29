package com.stefanini.todolist.service.impl;

import com.stefanini.todolist.model.Todo;
import com.stefanini.todolist.repository.TodoRepository;
import com.stefanini.todolist.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Todo criarNovoTodo(Todo todo) throws ResponseStatusException {

        Optional<Todo> existingTodo = todoRepository.findByTitulo(todo.getTitulo());

       if(existingTodo.isPresent()){
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Parece que esse 'todo' já existe.");
       }
       todo.setAtualizadoEm(LocalDateTime.now());
       todo.setCriadoEm(LocalDateTime.now());

       return todoRepository.save(todo);

    }

    @Override
    public Todo buscarTodo(Integer id) throws RuntimeException {

        Optional<Todo> todo = todoRepository.findById(id);

        if(todo.isPresent()){
            return todo.get();
        } else {
            throw new RuntimeException("Não foi possível encontrar o 'todo'.");
        }
    }

    @Override
    public Page<Todo> buscarTodos(Pageable pageable) {

        Page<Todo> todos = todoRepository.findAll(pageable);

        return todos;
    }

    @Override
    public Todo alterarTodo(Integer id, Todo newTodo) throws RuntimeException {

        Optional<Todo> todo = todoRepository.findById(id);

        if(todo.isPresent()){
            newTodo.setId(todo.get().getId());
            newTodo.setCriadoEm(todo.get().getCriadoEm());
            newTodo.setAtualizadoEm(LocalDateTime.now());

            return todoRepository.save(newTodo);
        } else {
            throw new RuntimeException("Esse 'todo' não existe e não pode ser alterado.");
        }

    }

    @Override
    public void deletarTodo(Integer id) {
        Optional<Todo> todo = todoRepository.findById(id);

        if(todo.isPresent()) {
            todoRepository.delete(todo.get());
        } else {
            throw new RuntimeException("O 'todo' com id: " + id + " não foi encontrado.");
        }
    }
}
