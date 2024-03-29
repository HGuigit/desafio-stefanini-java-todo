package com.stefanini.todolist.controllers;

import com.stefanini.todolist.dto.TodoDto;
import com.stefanini.todolist.model.Todo;
import com.stefanini.todolist.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    TarefaService tarefaService;

    @PostMapping(value = "/create")
    public ResponseEntity<Todo> criarUmNovoTodo(@RequestBody @Valid TodoDto todoDto) throws ResponseStatusException {

        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDto, todo);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarNovoTodo(todo));

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> buscarTodo(@PathVariable Integer id) throws RuntimeException {

        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.buscarTodo(id));
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<Todo>> buscarTodos(@PageableDefault(size = 10, page = 0, direction = Sort.Direction.ASC,
            sort = "id") Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.buscarTodos(pageable));
    }

}
