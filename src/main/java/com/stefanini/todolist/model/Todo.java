package com.stefanini.todolist.model;

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

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", columnDefinition = "NVARCHAR(MAX)")
    private String descricao;

    @Column(name = "completa", columnDefinition = "BIT DEFAULT 0")
    private Boolean completa;

    @Column(name = "status", columnDefinition = "NVARCHAR(20) DEFAULT 'Pendente'")
    private String status;

    @Column(name = "criado_em", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime atualizadoEm;

}