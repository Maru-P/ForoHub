package com.maru.foro.domain.curso.dto;

import com.maru.foro.domain.curso.Categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearCursoDTO(
    @NotBlank String nombre,
    @NotNull Categoria categoria
) {

}
