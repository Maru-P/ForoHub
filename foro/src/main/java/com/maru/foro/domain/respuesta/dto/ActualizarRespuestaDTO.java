package com.maru.foro.domain.respuesta.dto;

public record ActualizarRespuestaDTO(
    String mensaje,
    Boolean solucion,
    Boolean borrado
) {
}
