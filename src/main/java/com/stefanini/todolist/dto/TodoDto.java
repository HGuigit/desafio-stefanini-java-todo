package com.stefanini.todolist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.todolist.enums.TodoStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {

    @NotBlank
    @Size(max = 255)
    private String titulo;

    @NotBlank
    private String descricao;

    @NotNull
    private TodoStatusEnum status;

}
