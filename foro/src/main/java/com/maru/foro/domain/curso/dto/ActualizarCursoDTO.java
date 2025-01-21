package com.maru.foro.domain.curso.dto;

import com.maru.foro.domain.curso.Categoria;

public record ActualizarCursoDTO(
    String nombre,
    Categoria categoria,
    Boolean activo
) {

}
