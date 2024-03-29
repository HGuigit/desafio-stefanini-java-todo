package com.stefanini.todolist.model;

import com.stefanini.todolist.enums.StatusTodo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todoStatus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoStatus {

    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nome", nullable = false, length = 20)
    private StatusTodo nome;
}
