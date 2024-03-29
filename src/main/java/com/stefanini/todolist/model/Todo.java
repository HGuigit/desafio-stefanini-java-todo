package com.stefanini.todolist.model;

import com.stefanini.todolist.enums.TodoStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TodoStatusEnum status;

    @Column(name = "criado_em", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime atualizadoEm;

}