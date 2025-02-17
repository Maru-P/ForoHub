package com.maru.foro.domain.curso.dto;

import com.maru.foro.domain.curso.Categoria;
import com.maru.foro.domain.curso.Curso;

public record DetalleCursoDTO(
    Long id,
    String nombre,
    Categoria categoria,
    Boolean activo
) {
    public DetalleCursoDTO (Curso curso) {
        this(curso.getId(), 
        curso.getNombre(), 
        curso.getCategoria(), 
        curso.getActivo());
    }
}
