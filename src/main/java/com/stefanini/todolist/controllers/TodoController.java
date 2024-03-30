package com.stefanini.todolist.controllers;

import com.stefanini.todolist.dto.TodoDto;
import com.stefanini.todolist.exception.ResourceAlreadyExistsException;
import com.stefanini.todolist.exception.ResourceNotFoundException;
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

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    TarefaService tarefaService;

    @PostMapping(value = "/create")
    public ResponseEntity<Todo> criarUmNovoTodo(@RequestBody @Valid TodoDto todoDto) throws ResourceAlreadyExistsException {

        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDto, todo);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarNovoTodo(todo));

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> buscarTodo(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.buscarTodo(id));
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<Todo>> buscarTodos(@PageableDefault(size = 10, page = 0, direction = Sort.Direction.ASC,
            sort = "id") Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.buscarTodos(pageable));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> alterarTodo(@PathVariable(value = "id") Integer id, @RequestBody @Valid TodoDto todoDto) throws ResourceNotFoundException {

        Todo newTodo = new Todo();
        BeanUtils.copyProperties(todoDto, newTodo);

        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.alterarTodo(id, newTodo));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarTodo(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

        tarefaService.deletarTodo(id);
        return ResponseEntity.noContent().build();

    }


}
