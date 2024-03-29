package com.stefanini.todolist.controllers;

import com.stefanini.todolist.dto.TodoDto;
import com.stefanini.todolist.model.Todo;
import com.stefanini.todolist.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/todos/")
public class TodoController {

    @Autowired
    TarefaService tarefaService;

    @PostMapping(value = "/create")
    public ResponseEntity<Todo> criarUmNovoTodo(@RequestBody @Valid TodoDto todoDto) {

        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDto, todo);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarNovoTodo(todo));

    }

}
