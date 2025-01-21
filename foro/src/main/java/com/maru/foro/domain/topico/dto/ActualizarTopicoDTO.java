package com.maru.foro.domain.topico.dto;

import com.maru.foro.domain.topico.Estado;

public record ActualizarTopicoDTO (
        String titulo,
        String mensaje,
        Estado estado,
        Long cursoId
){
}
