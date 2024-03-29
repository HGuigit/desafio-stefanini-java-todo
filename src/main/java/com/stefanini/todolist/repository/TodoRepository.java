package com.stefanini.todolist.repository;

import com.stefanini.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    Optional<Todo> findByTitulo(String titulo);

}
