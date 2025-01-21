package com.maru.foro.domain.topico.dto;

import java.time.LocalDateTime;

import com.maru.foro.domain.curso.Categoria;
import com.maru.foro.domain.topico.Topico;
import com.maru.foro.domain.topico.Estado;
import com.maru.foro.domain.usuario.Usuario;

public record DetallesTopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        LocalDateTime ultimaActualizacion,
        Estado estado,
        String usuario,
        String curso,
        Categoria categoriaCurso

) {

    public DetallesTopicoDTO(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getUltimaActualizacion(),
                topico.getEstado(),
                topico.getUsuario().getUsername(),
                topico.getCurso().getNombre(),
                topico.getCurso().getCategoria()
        );
    }
}
